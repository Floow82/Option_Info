import copy
from abc import ABC, abstractmethod

import numpy as np


class TicTacToe:
    CELL_EMPTY = 0
    PLAYERS = {
        1: "X",
        2: "O",
    }
    STATUS_FULL = list(PLAYERS)[-1] + 1
    DISPLAY = {**PLAYERS, CELL_EMPTY: "."}

    def __init__(self, grid=None, player=None):
        if player is not None:
            if player not in self.PLAYERS:
                raise ValueError("Invalid player id")
            self.player = player
        else:
            self.player = list(self.PLAYERS.keys())[0]
        if grid is not None:
            if not isinstance(grid, np.ndarray) or grid.shape != (3, 3):
                raise ValueError("Grid must be a 3x3 NDarray")
            self.grid = grid.copy()
            self.winner = self._compute_winner()
        else:
            self.grid = np.full((3, 3), self.CELL_EMPTY, np.uint8)
            self.winner = None

    def copy(self):
        return copy.deepcopy(self)

    def __deepcopy__(self, memo):
        cls = self.__class__
        cpy = cls.__new__(cls)
        cpy.player = self.player
        cpy.grid = self.grid.copy()
        cpy.winner = self.winner
        return cpy

    def play(self, coordinates, player=None):
        if self.winner is not None:
            raise ValueError("Invalid game state: game has ended")
        if self.grid[coordinates] != self.CELL_EMPTY:
            raise ValueError("Invalid Cell")
        if player is not None:
            if player not in self.PLAYERS:
                raise ValueError("Invalid player id")
            if player != self.player:
                raise ValueError(f"Not player {self.PLAYERS[player]}'s turn")
        else:
            player = self.player
        self.grid[coordinates] = player
        self.player = list(self.PLAYERS)[
            (list(self.PLAYERS).index(player) + 1) % len(self.PLAYERS)
        ]
        return self._update_winner(coordinates)

    def get_playable_cells(self):
        if self.winner is not None:
            return []
        return list(zip(*np.where(self.grid == self.CELL_EMPTY)))

    def get_state(self):
        return self.grid, self.player

    def _compute_winner(self):
        for player in self.PLAYERS:
            mask = self.grid == player
            for axis in (0, 1):
                if mask.all(axis=axis).any():
                    return player
            if np.diag(mask).all():
                return player
            if np.diag(mask[:, ::-1]).all():
                return player
        if (self.grid != self.CELL_EMPTY).all():
            return self.STATUS_FULL
        return None

    def _update_winner(self, coordinates):
        player = self.grid[coordinates]
        x, y = coordinates
        mask = self.grid == player
        if (
            mask[x, :].all()
            or mask[:, y].all()
            or (x == y and np.diag(mask).all())
            or (x == 2 - y and np.diag(mask[:, ::-1]).all())
        ):
            self.winner = player
            return True
        if (self.grid == self.CELL_EMPTY).any():
            return False
        self.winner = self.STATUS_FULL
        return True

    def __str__(self):
        return "\n".join(
            [" ".join([" ", "A", "B", "C"])]
            + [
                " ".join([str(i)] + [self.DISPLAY[self.grid[i, j]] for j in range(3)])
                for i in range(3)
            ]
        )


class TicTacToeRL(TicTacToe):
    def get_state(self):
        grid, player = super().get_state()
        # Original cell values are: 0: empty, 1: p1, 2: p2
        # Transformed cell values are: 0: empty, -1: opponent, 1: current player
        state = (grid.astype(int) + 1) % 3 - 1
        if player == 2:
            state = -state
        return state

    def reward(self):
        winner = self.winner
        if winner is None or winner == self.STATUS_FULL:
            return 0
        if winner == self.player:
            return 1
        return -1


class TicTacToePlayer(ABC):
    @abstractmethod
    def play(self, game):
        """Play a move.

        Parameters
        ----------
        game : TicTacToeRL
            Instance of the current game state.
            This instance should be read-only.

        Returns
        -------
        move : (int, int)
            Coordinates of the cell to play on.
        """


def main():
    def ask_coords():
        prompt = input()
        return int(prompt[1]), ["A", "B", "C"].index(prompt[0].upper())

    game = TicTacToe()
    while game.winner is None:
        valid = False
        while not valid:
            try:
                print(game)
                print(f"Player {game.PLAYERS[game.player]}'s turn: enter coordinates")
                coords = ask_coords()
                game.play(coords)
                valid = True
            except (ValueError, IndexError) as ex:
                print(ex)
    winner = game.winner
    print(game)
    if winner == game.STATUS_FULL:
        print("This game is a draw")
    else:
        print(f"The winner is {game.PLAYERS[winner]}")


if __name__ == "__main__":
    main()
