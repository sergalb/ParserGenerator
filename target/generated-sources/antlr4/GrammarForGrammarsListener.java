// Generated from GrammarForGrammars.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarForGrammarsParser}.
 */
public interface GrammarForGrammarsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarForGrammarsParser#grammar_}.
	 * @param ctx the parse tree
	 */
	void enterGrammar_(GrammarForGrammarsParser.Grammar_Context ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarForGrammarsParser#grammar_}.
	 * @param ctx the parse tree
	 */
	void exitGrammar_(GrammarForGrammarsParser.Grammar_Context ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarForGrammarsParser#parsingRule}.
	 * @param ctx the parse tree
	 */
	void enterParsingRule(GrammarForGrammarsParser.ParsingRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarForGrammarsParser#parsingRule}.
	 * @param ctx the parse tree
	 */
	void exitParsingRule(GrammarForGrammarsParser.ParsingRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarForGrammarsParser#parsingAtom}.
	 * @param ctx the parse tree
	 */
	void enterParsingAtom(GrammarForGrammarsParser.ParsingAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarForGrammarsParser#parsingAtom}.
	 * @param ctx the parse tree
	 */
	void exitParsingAtom(GrammarForGrammarsParser.ParsingAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarForGrammarsParser#lexingRule}.
	 * @param ctx the parse tree
	 */
	void enterLexingRule(GrammarForGrammarsParser.LexingRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarForGrammarsParser#lexingRule}.
	 * @param ctx the parse tree
	 */
	void exitLexingRule(GrammarForGrammarsParser.LexingRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarForGrammarsParser#lexingAtom}.
	 * @param ctx the parse tree
	 */
	void enterLexingAtom(GrammarForGrammarsParser.LexingAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarForGrammarsParser#lexingAtom}.
	 * @param ctx the parse tree
	 */
	void exitLexingAtom(GrammarForGrammarsParser.LexingAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarForGrammarsParser#fragmentRule}.
	 * @param ctx the parse tree
	 */
	void enterFragmentRule(GrammarForGrammarsParser.FragmentRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarForGrammarsParser#fragmentRule}.
	 * @param ctx the parse tree
	 */
	void exitFragmentRule(GrammarForGrammarsParser.FragmentRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarForGrammarsParser#skipingCharacters}.
	 * @param ctx the parse tree
	 */
	void enterSkipingCharacters(GrammarForGrammarsParser.SkipingCharactersContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarForGrammarsParser#skipingCharacters}.
	 * @param ctx the parse tree
	 */
	void exitSkipingCharacters(GrammarForGrammarsParser.SkipingCharactersContext ctx);
}