import random
from functools import partial

from ipywidgets import Button, GridBox, Layout, Output, VBox

from tictactoe import TicTacToeRL


class GameWidget(TicTacToeRL):
    def __init__(self, players, start=None, verbose=False, auto_start=True):
        if start is None:
            self.current_player = random.choice([0, 1])
        elif start in {0, 1}:
            self.current_player = start
        else:
            raise ValueError("Invalid player index")
        if len(players) != 2:
            raise ValueError("Game is for two players only")
        TicTacToeRL.__init__(self, player=2 if self.current_player else 1)
        self.players = players
        self.verbose = verbose
        self.auto_start = auto_start
        self.logger = Output()
        self.buttons = {
            (i, j): Button(
                value=False,
                description="",
                layout=Layout(width="90%"),
                tooltip=f"cell ({i}, {j})",
            )
            for i in range(3)
            for j in range(3)
        }
        if "human" in self.players:
            for pos, b in self.buttons.items():
                b.on_click(partial(self.on_click, coordinates=pos))
        self.box = GridBox(
            list(self.buttons.values()),
            layout=Layout(grid_template_columns="repeat(3, 50px)"),
        )
        self.ui = VBox(children=[self.box, self.logger])
        self.action = None

    def update_button(self, coordinates):
        button = self.buttons[coordinates]
        button.disabled = True
        if self.current_player == 0:
            button.description = "X"
            button.button_style = "success"
        else:
            button.description = "O"
            button.button_style = "danger"

    def on_click(self, _button, coordinates):
        with self.logger:
            if self.verbose:
                print(f"clicked on button {coordinates}")
            if self.players[self.current_player] != "human" or self.winner is not None:
                return
            self.play(coordinates)
            self.update_button(coordinates)
            self.current_player = 1 - self.current_player
            self.auto_play()

    def auto_play(self):
        with self.logger:
            while not self.check_and_display_winner():
                player = self.players[self.current_player]
                if player == "human":
                    return
                coordinates = player.play(self)
                self.play(coordinates)
                self.update_button(coordinates)
                self.current_player = 1 - self.current_player

    def check_and_display_winner(self):
        winner = self.winner
        if winner is not None:
            if winner == self.STATUS_FULL:
                print("This game is a draw")
            else:
                print(f"The winner is {self.PLAYERS[winner]}")
            return True
        return False

    def _repr_mimebundle_(self, **kwargs):
        if self.auto_start:
            self.auto_play()
        return self.ui._repr_mimebundle_(**kwargs)
