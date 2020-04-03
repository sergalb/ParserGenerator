grammar Claculator;

start: ex;
ex: ex PLUS t {it -> (it[0].value.toDouble() + it[2].value.toDouble()).toString()} ;
ex: ex MINUS t {it -> (it[0].value.toDouble() - it[2].value.toDouble()).toString()} ;
ex: t;
t : t MUL f {it -> (it[0].value.toDouble() * it[2].value.toDouble()).toString()} ;
t : t DIV f {it -> (it[0].value.toDouble() / it[2].value.toDouble()).toString()} ;
t : f;
f : g POW f {it -> (it[0].value.toDouble().pow(it[2].value.toDouble()).toString())};
f : g;
g : LPAREN ex RPAREN {it -> it[1].value};
g : MINUS g { it -> (-it[1].value.toDouble()).toString()};
g : X;

X
    : 	'0'
    |	[1-9]([0-9]+)?
   	;
PLUS : '+';
MINUS: '-';
MUL : '*';
DIV: '/';
LPAREN: '(';
RPAREN: ')';
POW: '\^';
skip: [ \t\n\r];