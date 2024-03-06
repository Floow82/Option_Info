grammar calculette;

expr
    : VAR '+' som EOF
    | som EDF
    ;

NB: [0-9]+;
VAR [_a-zA-Z][_a-zA-Z0-9]*;
WS  : (' '|'\t'|'\r'|'\n')+ -> skip;
