// Generated from GrammarForGrammars.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarForGrammarsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		GRAMMAR=1, FRAGMENT=2, SKIP_=3, LPAREN=4, RPAREN=5, LBRACK=6, RBRACK=7, 
		LBRACE=8, RBRACE=9, PARSER_IDENTIFIER=10, LEXER_IDENTIFIER=11, APOSTROPHE=12, 
		SEMI=13, COLON=14, OR=15, QUESTION=16, STAR=17, PLUS=18, WS=19, LINE_COMMENT=20, 
		LexerLiteral=21, CodeLiteral=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"GRAMMAR", "FRAGMENT", "SKIP_", "LPAREN", "RPAREN", "LBRACK", "RBRACK", 
			"LBRACE", "RBRACE", "PARSER_IDENTIFIER", "LEXER_IDENTIFIER", "UppercaseLetter", 
			"LowercaseLetter", "Letter", "APOSTROPHE", "SEMI", "COLON", "OR", "QUESTION", 
			"STAR", "PLUS", "WS", "LINE_COMMENT", "LexerLiteral", "CodeLiteral", 
			"LITERAL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'grammar'", "'fragment'", "'skip'", "'('", "')'", "'['", "']'", 
			"'{'", "'}'", null, null, "'''", "';'", "':'", "'|'", "'?'", "'*'", "'+'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "GRAMMAR", "FRAGMENT", "SKIP_", "LPAREN", "RPAREN", "LBRACK", "RBRACK", 
			"LBRACE", "RBRACE", "PARSER_IDENTIFIER", "LEXER_IDENTIFIER", "APOSTROPHE", 
			"SEMI", "COLON", "OR", "QUESTION", "STAR", "PLUS", "WS", "LINE_COMMENT", 
			"LexerLiteral", "CodeLiteral"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public GrammarForGrammarsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GrammarForGrammars.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u00a9\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\7\13\\\n\13\f\13\16\13_\13\13\3\f\3\f"+
		"\7\fc\n\f\f\f\16\ff\13\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3"+
		"\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\6\27}\n\27"+
		"\r\27\16\27~\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u0087\n\30\f\30\16\30"+
		"\u008a\13\30\3\30\3\30\3\31\3\31\6\31\u0090\n\31\r\31\16\31\u0091\3\31"+
		"\3\31\3\31\3\31\6\31\u0098\n\31\r\31\16\31\u0099\3\31\3\31\5\31\u009e"+
		"\n\31\3\32\3\32\6\32\u00a2\n\32\r\32\16\32\u00a3\3\32\3\32\3\33\3\33\5"+
		"\u0091\u0099\u00a3\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\2\33\2\35\2\37\16!\17#\20%\21\'\22)\23+\24-\25/\26\61\27\63\30"+
		"\65\2\3\2\7\3\2C\\\3\2c|\5\2C\\aac|\5\2\13\f\16\17\"\"\4\2\f\f\17\17\2"+
		"\u00ac\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3\67"+
		"\3\2\2\2\5?\3\2\2\2\7H\3\2\2\2\tM\3\2\2\2\13O\3\2\2\2\rQ\3\2\2\2\17S\3"+
		"\2\2\2\21U\3\2\2\2\23W\3\2\2\2\25Y\3\2\2\2\27`\3\2\2\2\31g\3\2\2\2\33"+
		"i\3\2\2\2\35k\3\2\2\2\37m\3\2\2\2!o\3\2\2\2#q\3\2\2\2%s\3\2\2\2\'u\3\2"+
		"\2\2)w\3\2\2\2+y\3\2\2\2-|\3\2\2\2/\u0082\3\2\2\2\61\u009d\3\2\2\2\63"+
		"\u009f\3\2\2\2\65\u00a7\3\2\2\2\678\7i\2\289\7t\2\29:\7c\2\2:;\7o\2\2"+
		";<\7o\2\2<=\7c\2\2=>\7t\2\2>\4\3\2\2\2?@\7h\2\2@A\7t\2\2AB\7c\2\2BC\7"+
		"i\2\2CD\7o\2\2DE\7g\2\2EF\7p\2\2FG\7v\2\2G\6\3\2\2\2HI\7u\2\2IJ\7m\2\2"+
		"JK\7k\2\2KL\7r\2\2L\b\3\2\2\2MN\7*\2\2N\n\3\2\2\2OP\7+\2\2P\f\3\2\2\2"+
		"QR\7]\2\2R\16\3\2\2\2ST\7_\2\2T\20\3\2\2\2UV\7}\2\2V\22\3\2\2\2WX\7\177"+
		"\2\2X\24\3\2\2\2Y]\5\33\16\2Z\\\5\35\17\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2"+
		"\2]^\3\2\2\2^\26\3\2\2\2_]\3\2\2\2`d\5\31\r\2ac\5\35\17\2ba\3\2\2\2cf"+
		"\3\2\2\2db\3\2\2\2de\3\2\2\2e\30\3\2\2\2fd\3\2\2\2gh\t\2\2\2h\32\3\2\2"+
		"\2ij\t\3\2\2j\34\3\2\2\2kl\t\4\2\2l\36\3\2\2\2mn\7)\2\2n \3\2\2\2op\7"+
		"=\2\2p\"\3\2\2\2qr\7<\2\2r$\3\2\2\2st\7~\2\2t&\3\2\2\2uv\7A\2\2v(\3\2"+
		"\2\2wx\7,\2\2x*\3\2\2\2yz\7-\2\2z,\3\2\2\2{}\t\5\2\2|{\3\2\2\2}~\3\2\2"+
		"\2~|\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\b\27\2\2\u0081"+
		".\3\2\2\2\u0082\u0083\7\61\2\2\u0083\u0084\7\61\2\2\u0084\u0088\3\2\2"+
		"\2\u0085\u0087\n\6\2\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086"+
		"\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u0088\3\2\2\2\u008b"+
		"\u008c\b\30\2\2\u008c\60\3\2\2\2\u008d\u008f\5\37\20\2\u008e\u0090\5\65"+
		"\33\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\5\37\20\2\u0094\u009e\3"+
		"\2\2\2\u0095\u0097\5\r\7\2\u0096\u0098\5\65\33\2\u0097\u0096\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\3\2"+
		"\2\2\u009b\u009c\5\17\b\2\u009c\u009e\3\2\2\2\u009d\u008d\3\2\2\2\u009d"+
		"\u0095\3\2\2\2\u009e\62\3\2\2\2\u009f\u00a1\5\21\t\2\u00a0\u00a2\5\65"+
		"\33\2\u00a1\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a3"+
		"\u00a1\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\5\23\n\2\u00a6\64\3\2\2"+
		"\2\u00a7\u00a8\13\2\2\2\u00a8\66\3\2\2\2\13\2]d~\u0088\u0091\u0099\u009d"+
		"\u00a3\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}