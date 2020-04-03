// Generated from GrammarForGrammars.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarForGrammarsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		GRAMMAR=1, FRAGMENT=2, SKIP_=3, LPAREN=4, RPAREN=5, LBRACK=6, RBRACK=7, 
		LBRACE=8, RBRACE=9, PARSER_IDENTIFIER=10, LEXER_IDENTIFIER=11, APOSTROPHE=12, 
		SEMI=13, COLON=14, OR=15, QUESTION=16, STAR=17, PLUS=18, WS=19, LINE_COMMENT=20, 
		LexerLiteral=21, CodeLiteral=22;
	public static final int
		RULE_grammar_ = 0, RULE_parsingRule = 1, RULE_parsingAtom = 2, RULE_lexingRule = 3, 
		RULE_lexingAtom = 4, RULE_fragmentRule = 5, RULE_skipingCharacters = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"grammar_", "parsingRule", "parsingAtom", "lexingRule", "lexingAtom", 
			"fragmentRule", "skipingCharacters"
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

	@Override
	public String getGrammarFileName() { return "GrammarForGrammars.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarForGrammarsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Grammar_Context extends org.antlr.v4.runtime.RuleContextWithAltNum {
		public TerminalNode GRAMMAR() { return getToken(GrammarForGrammarsParser.GRAMMAR, 0); }
		public TerminalNode LEXER_IDENTIFIER() { return getToken(GrammarForGrammarsParser.LEXER_IDENTIFIER, 0); }
		public TerminalNode SEMI() { return getToken(GrammarForGrammarsParser.SEMI, 0); }
		public List<ParsingRuleContext> parsingRule() {
			return getRuleContexts(ParsingRuleContext.class);
		}
		public ParsingRuleContext parsingRule(int i) {
			return getRuleContext(ParsingRuleContext.class,i);
		}
		public List<LexingRuleContext> lexingRule() {
			return getRuleContexts(LexingRuleContext.class);
		}
		public LexingRuleContext lexingRule(int i) {
			return getRuleContext(LexingRuleContext.class,i);
		}
		public List<FragmentRuleContext> fragmentRule() {
			return getRuleContexts(FragmentRuleContext.class);
		}
		public FragmentRuleContext fragmentRule(int i) {
			return getRuleContext(FragmentRuleContext.class,i);
		}
		public SkipingCharactersContext skipingCharacters() {
			return getRuleContext(SkipingCharactersContext.class,0);
		}
		public Grammar_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grammar_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarsListener ) ((GrammarForGrammarsListener)listener).enterGrammar_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarsListener ) ((GrammarForGrammarsListener)listener).exitGrammar_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarsVisitor ) return ((GrammarForGrammarsVisitor<? extends T>)visitor).visitGrammar_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Grammar_Context grammar_() throws RecognitionException {
		Grammar_Context _localctx = new Grammar_Context(_ctx, getState());
		enterRule(_localctx, 0, RULE_grammar_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			match(GRAMMAR);
			setState(15);
			match(LEXER_IDENTIFIER);
			setState(16);
			match(SEMI);
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FRAGMENT) | (1L << PARSER_IDENTIFIER) | (1L << LEXER_IDENTIFIER))) != 0)) {
				{
				setState(20);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PARSER_IDENTIFIER:
					{
					setState(17);
					parsingRule();
					}
					break;
				case LEXER_IDENTIFIER:
					{
					setState(18);
					lexingRule();
					}
					break;
				case FRAGMENT:
					{
					setState(19);
					fragmentRule();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SKIP_) {
				{
				setState(25);
				skipingCharacters();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParsingRuleContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
		public TerminalNode PARSER_IDENTIFIER() { return getToken(GrammarForGrammarsParser.PARSER_IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(GrammarForGrammarsParser.COLON, 0); }
		public TerminalNode SEMI() { return getToken(GrammarForGrammarsParser.SEMI, 0); }
		public List<ParsingAtomContext> parsingAtom() {
			return getRuleContexts(ParsingAtomContext.class);
		}
		public ParsingAtomContext parsingAtom(int i) {
			return getRuleContext(ParsingAtomContext.class,i);
		}
		public TerminalNode CodeLiteral() { return getToken(GrammarForGrammarsParser.CodeLiteral, 0); }
		public ParsingRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parsingRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarsListener ) ((GrammarForGrammarsListener)listener).enterParsingRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarsListener ) ((GrammarForGrammarsListener)listener).exitParsingRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarsVisitor ) return ((GrammarForGrammarsVisitor<? extends T>)visitor).visitParsingRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParsingRuleContext parsingRule() throws RecognitionException {
		ParsingRuleContext _localctx = new ParsingRuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_parsingRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(PARSER_IDENTIFIER);
			setState(29);
			match(COLON);
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PARSER_IDENTIFIER || _la==LEXER_IDENTIFIER) {
				{
				{
				setState(30);
				parsingAtom();
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CodeLiteral) {
				{
				setState(36);
				match(CodeLiteral);
				}
			}

			setState(39);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParsingAtomContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
		public TerminalNode LEXER_IDENTIFIER() { return getToken(GrammarForGrammarsParser.LEXER_IDENTIFIER, 0); }
		public TerminalNode PARSER_IDENTIFIER() { return getToken(GrammarForGrammarsParser.PARSER_IDENTIFIER, 0); }
		public ParsingAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parsingAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarsListener ) ((GrammarForGrammarsListener)listener).enterParsingAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarsListener ) ((GrammarForGrammarsListener)listener).exitParsingAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarsVisitor ) return ((GrammarForGrammarsVisitor<? extends T>)visitor).visitParsingAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParsingAtomContext parsingAtom() throws RecognitionException {
		ParsingAtomContext _localctx = new ParsingAtomContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_parsingAtom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_la = _input.LA(1);
			if ( !(_la==PARSER_IDENTIFIER || _la==LEXER_IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexingRuleContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
		public TerminalNode LEXER_IDENTIFIER() { return getToken(GrammarForGrammarsParser.LEXER_IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(GrammarForGrammarsParser.COLON, 0); }
		public TerminalNode SEMI() { return getToken(GrammarForGrammarsParser.SEMI, 0); }
		public List<LexingAtomContext> lexingAtom() {
			return getRuleContexts(LexingAtomContext.class);
		}
		public LexingAtomContext lexingAtom(int i) {
			return getRuleContext(LexingAtomContext.class,i);
		}
		public LexingRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexingRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarsListener ) ((GrammarForGrammarsListener)listener).enterLexingRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarsListener ) ((GrammarForGrammarsListener)listener).exitLexingRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarsVisitor ) return ((GrammarForGrammarsVisitor<? extends T>)visitor).visitLexingRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LexingRuleContext lexingRule() throws RecognitionException {
		LexingRuleContext _localctx = new LexingRuleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_lexingRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(LEXER_IDENTIFIER);
			setState(44);
			match(COLON);
			setState(46); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(45);
				lexingAtom(0);
				}
				}
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << LEXER_IDENTIFIER) | (1L << LexerLiteral))) != 0) );
			setState(50);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexingAtomContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
		public TerminalNode LexerLiteral() { return getToken(GrammarForGrammarsParser.LexerLiteral, 0); }
		public TerminalNode QUESTION() { return getToken(GrammarForGrammarsParser.QUESTION, 0); }
		public TerminalNode STAR() { return getToken(GrammarForGrammarsParser.STAR, 0); }
		public TerminalNode PLUS() { return getToken(GrammarForGrammarsParser.PLUS, 0); }
		public TerminalNode LEXER_IDENTIFIER() { return getToken(GrammarForGrammarsParser.LEXER_IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(GrammarForGrammarsParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GrammarForGrammarsParser.RPAREN, 0); }
		public List<LexingAtomContext> lexingAtom() {
			return getRuleContexts(LexingAtomContext.class);
		}
		public LexingAtomContext lexingAtom(int i) {
			return getRuleContext(LexingAtomContext.class,i);
		}
		public TerminalNode OR() { return getToken(GrammarForGrammarsParser.OR, 0); }
		public LexingAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexingAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarsListener ) ((GrammarForGrammarsListener)listener).enterLexingAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarsListener ) ((GrammarForGrammarsListener)listener).exitLexingAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarsVisitor ) return ((GrammarForGrammarsVisitor<? extends T>)visitor).visitLexingAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LexingAtomContext lexingAtom() throws RecognitionException {
		return lexingAtom(0);
	}

	private LexingAtomContext lexingAtom(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LexingAtomContext _localctx = new LexingAtomContext(_ctx, _parentState);
		LexingAtomContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_lexingAtom, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LexerLiteral:
				{
				setState(53);
				match(LexerLiteral);
				setState(55);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(54);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << QUESTION) | (1L << STAR) | (1L << PLUS))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				}
				break;
			case LEXER_IDENTIFIER:
				{
				setState(57);
				match(LEXER_IDENTIFIER);
				}
				break;
			case LPAREN:
				{
				setState(58);
				match(LPAREN);
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(59);
					lexingAtom(0);
					}
					}
					setState(62); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << LEXER_IDENTIFIER) | (1L << LexerLiteral))) != 0) );
				setState(64);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(79);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(77);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new LexingAtomContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_lexingAtom);
						setState(68);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(69);
						match(OR);
						setState(70);
						lexingAtom(8);
						}
						break;
					case 2:
						{
						_localctx = new LexingAtomContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_lexingAtom);
						setState(71);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(72);
						match(QUESTION);
						}
						break;
					case 3:
						{
						_localctx = new LexingAtomContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_lexingAtom);
						setState(73);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(74);
						match(PLUS);
						}
						break;
					case 4:
						{
						_localctx = new LexingAtomContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_lexingAtom);
						setState(75);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(76);
						match(STAR);
						}
						break;
					}
					} 
				}
				setState(81);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FragmentRuleContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
		public TerminalNode FRAGMENT() { return getToken(GrammarForGrammarsParser.FRAGMENT, 0); }
		public TerminalNode LEXER_IDENTIFIER() { return getToken(GrammarForGrammarsParser.LEXER_IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(GrammarForGrammarsParser.COLON, 0); }
		public TerminalNode SEMI() { return getToken(GrammarForGrammarsParser.SEMI, 0); }
		public List<LexingAtomContext> lexingAtom() {
			return getRuleContexts(LexingAtomContext.class);
		}
		public LexingAtomContext lexingAtom(int i) {
			return getRuleContext(LexingAtomContext.class,i);
		}
		public FragmentRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fragmentRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarsListener ) ((GrammarForGrammarsListener)listener).enterFragmentRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarsListener ) ((GrammarForGrammarsListener)listener).exitFragmentRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarsVisitor ) return ((GrammarForGrammarsVisitor<? extends T>)visitor).visitFragmentRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FragmentRuleContext fragmentRule() throws RecognitionException {
		FragmentRuleContext _localctx = new FragmentRuleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fragmentRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(FRAGMENT);
			setState(83);
			match(LEXER_IDENTIFIER);
			setState(84);
			match(COLON);
			setState(86); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(85);
				lexingAtom(0);
				}
				}
				setState(88); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << LEXER_IDENTIFIER) | (1L << LexerLiteral))) != 0) );
			setState(90);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SkipingCharactersContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
		public TerminalNode SKIP_() { return getToken(GrammarForGrammarsParser.SKIP_, 0); }
		public TerminalNode COLON() { return getToken(GrammarForGrammarsParser.COLON, 0); }
		public TerminalNode LexerLiteral() { return getToken(GrammarForGrammarsParser.LexerLiteral, 0); }
		public TerminalNode SEMI() { return getToken(GrammarForGrammarsParser.SEMI, 0); }
		public SkipingCharactersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skipingCharacters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarsListener ) ((GrammarForGrammarsListener)listener).enterSkipingCharacters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarsListener ) ((GrammarForGrammarsListener)listener).exitSkipingCharacters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarsVisitor ) return ((GrammarForGrammarsVisitor<? extends T>)visitor).visitSkipingCharacters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkipingCharactersContext skipingCharacters() throws RecognitionException {
		SkipingCharactersContext _localctx = new SkipingCharactersContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_skipingCharacters);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(92);
			match(SKIP_);
			setState(93);
			match(COLON);
			setState(94);
			match(LexerLiteral);
			setState(95);
			match(SEMI);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return lexingAtom_sempred((LexingAtomContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean lexingAtom_sempred(LexingAtomContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30d\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3\2\7\2"+
		"\27\n\2\f\2\16\2\32\13\2\3\2\5\2\35\n\2\3\3\3\3\3\3\7\3\"\n\3\f\3\16\3"+
		"%\13\3\3\3\5\3(\n\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\6\5\61\n\5\r\5\16\5\62"+
		"\3\5\3\5\3\6\3\6\3\6\5\6:\n\6\3\6\3\6\3\6\6\6?\n\6\r\6\16\6@\3\6\3\6\5"+
		"\6E\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6P\n\6\f\6\16\6S\13\6\3"+
		"\7\3\7\3\7\3\7\6\7Y\n\7\r\7\16\7Z\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\2\3"+
		"\n\t\2\4\6\b\n\f\16\2\4\3\2\f\r\3\2\22\24\2l\2\20\3\2\2\2\4\36\3\2\2\2"+
		"\6+\3\2\2\2\b-\3\2\2\2\nD\3\2\2\2\fT\3\2\2\2\16^\3\2\2\2\20\21\7\3\2\2"+
		"\21\22\7\r\2\2\22\30\7\17\2\2\23\27\5\4\3\2\24\27\5\b\5\2\25\27\5\f\7"+
		"\2\26\23\3\2\2\2\26\24\3\2\2\2\26\25\3\2\2\2\27\32\3\2\2\2\30\26\3\2\2"+
		"\2\30\31\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\33\35\5\16\b\2\34\33\3\2"+
		"\2\2\34\35\3\2\2\2\35\3\3\2\2\2\36\37\7\f\2\2\37#\7\20\2\2 \"\5\6\4\2"+
		"! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\'\3\2\2\2%#\3\2\2\2&(\7\30"+
		"\2\2\'&\3\2\2\2\'(\3\2\2\2()\3\2\2\2)*\7\17\2\2*\5\3\2\2\2+,\t\2\2\2,"+
		"\7\3\2\2\2-.\7\r\2\2.\60\7\20\2\2/\61\5\n\6\2\60/\3\2\2\2\61\62\3\2\2"+
		"\2\62\60\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\65\7\17\2\2\65\t\3\2\2"+
		"\2\66\67\b\6\1\2\679\7\27\2\28:\t\3\2\298\3\2\2\29:\3\2\2\2:E\3\2\2\2"+
		";E\7\r\2\2<>\7\6\2\2=?\5\n\6\2>=\3\2\2\2?@\3\2\2\2@>\3\2\2\2@A\3\2\2\2"+
		"AB\3\2\2\2BC\7\7\2\2CE\3\2\2\2D\66\3\2\2\2D;\3\2\2\2D<\3\2\2\2EQ\3\2\2"+
		"\2FG\f\t\2\2GH\7\21\2\2HP\5\n\6\nIJ\f\5\2\2JP\7\22\2\2KL\f\4\2\2LP\7\24"+
		"\2\2MN\f\3\2\2NP\7\23\2\2OF\3\2\2\2OI\3\2\2\2OK\3\2\2\2OM\3\2\2\2PS\3"+
		"\2\2\2QO\3\2\2\2QR\3\2\2\2R\13\3\2\2\2SQ\3\2\2\2TU\7\4\2\2UV\7\r\2\2V"+
		"X\7\20\2\2WY\5\n\6\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\\\3\2\2"+
		"\2\\]\7\17\2\2]\r\3\2\2\2^_\7\5\2\2_`\7\20\2\2`a\7\27\2\2ab\7\17\2\2b"+
		"\17\3\2\2\2\16\26\30\34#\'\629@DOQZ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}