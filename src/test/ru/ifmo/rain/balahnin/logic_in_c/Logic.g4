grammar Claculator;

start: ex;
ex: ex OR or ;
ex: ex XOR or;
ex: or;
or: or AND atom;
or : atom;
atom: NOT atom;
atom : LPAREN ex RPAREN;
atom: X;

X
    : 	'0'
    |	[1-9]([0-9]+)?
   	;
OR : '\|';
AND: '\&';
XOR: '\^';
NOT: '!';
LPAREN: '(';
RPAREN: ')';
skip: [ \t\n\r];