// Generated from GrammarForGrammars.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarForGrammarsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarForGrammarsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarForGrammarsParser#grammar_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrammar_(GrammarForGrammarsParser.Grammar_Context ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarForGrammarsParser#parsingRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParsingRule(GrammarForGrammarsParser.ParsingRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarForGrammarsParser#parsingAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParsingAtom(GrammarForGrammarsParser.ParsingAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarForGrammarsParser#lexingRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLexingRule(GrammarForGrammarsParser.LexingRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarForGrammarsParser#lexingAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLexingAtom(GrammarForGrammarsParser.LexingAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarForGrammarsParser#fragmentRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFragmentRule(GrammarForGrammarsParser.FragmentRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarForGrammarsParser#skipingCharacters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipingCharacters(GrammarForGrammarsParser.SkipingCharactersContext ctx);
}