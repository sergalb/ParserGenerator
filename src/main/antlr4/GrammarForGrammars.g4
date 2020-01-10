grammar GrammarForGrammars;

grammar_
    :  GRAMMAR LEXER_IDENTIFIER SEMI (parsingRule | lexingRule | fragmentRule)* skipingCharacters?
    ;

parsingRule
    :   PARSER_IDENTIFIER COLON parsingAtom+ SEMI
    ;

parsingAtom
    :   lexingAtom
    |   PARSER_IDENTIFIER
    |   parsingAtom OR parsingAtom
    |   LPAREN parsingAtom+ RPAREN
    |   parsingAtom QUESTION
    |   parsingAtom PLUS
    |   parsingAtom STAR
    |   parsingAtom OR
    ;

lexingRule
    :   LEXER_IDENTIFIER COLON lexingAtom+ SEMI
    ;

lexingAtom
    :   lexingAtom OR lexingAtom
    |   LexerLiteral (QUESTION | STAR | PLUS)?
    |   LEXER_IDENTIFIER
    |   LPAREN lexingAtom+ RPAREN
    |   lexingAtom QUESTION
    |   lexingAtom PLUS
    |   lexingAtom STAR
    ;

fragmentRule
    :   FRAGMENT LEXER_IDENTIFIER COLON lexingAtom+ SEMI
    ;

skipingCharacters: (SKIP_ COLON  LexerLiteral SEMI);


//Lexer

GRAMMAR : 'grammar';
FRAGMENT : 'fragment';
SKIP_ : 'skip';
LPAREN : '(';
RPAREN : ')';
LBRACK : '[';
RBRACK : ']';


PARSER_IDENTIFIER : LowercaseLetter Letter*;
LEXER_IDENTIFIER : UppercaseLetter Letter*;


fragment
UppercaseLetter : [A-Z];

fragment
LowercaseLetter : [a-z];

fragment
Letter : [a-zA-Z_];

APOSTROPHE : '\'';
SEMI : ';';
COLON : ':';
OR : '|';
QUESTION : '?';
STAR : '*';
PLUS : '+';


WS  :  [ \t\r\n\u000C]+ -> channel(HIDDEN)
    ;


LINE_COMMENT
    :   '//' ~[\r\n]* -> channel(HIDDEN)
    ;


LexerLiteral
    : APOSTROPHE LITERAL+? APOSTROPHE
    | LBRACK LITERAL+? RBRACK
    ;


fragment
LITERAL : . ;
