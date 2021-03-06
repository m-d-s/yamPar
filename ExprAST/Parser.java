/* Generated By:JavaCC: Do not edit this line. Parser.java */
import ast.*;
public class Parser implements ParserConstants {
  public static void main(String[] args) {
     new Parser(System.in);
     try {
       Expr e = Top();
       new IndentOutput(System.out).indent(e);
     } catch (ParseException e) {
       System.out.println("Invalid syntax at ("
                          + token.beginColumn + ","
                          + token.beginLine + "), "
                          + token.image);
     } catch (TokenMgrError e) {
       System.out.println(e.getMessage());
     }
  }

//- Parser Functions---------------------------------------------------
  static final public Expr Top() throws ParseException {
              Expr e;
    e = Expr();
    jj_consume_token(0);
      {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public Expr Expr() throws ParseException {
               Expr e;
    e = LogOr();
      {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public Expr LogOr() throws ParseException {
                Expr e, p;
    e = LogAnd();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LOR:
      jj_consume_token(LOR);
      p = LogOr();
                                  e = new LOr(e,p);
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
      {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public Expr LogAnd() throws ParseException {
                 Expr e, p;
    e = Comp();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LAND:
      jj_consume_token(LAND);
      p = LogAnd();
                                 e = new LAnd(e,p);
      break;
    default:
      jj_la1[1] = jj_gen;
      ;
    }
      {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public Expr Comp() throws ParseException {
               Expr e, p;
    e = AddSub();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LT:
    case LTEQ:
    case GT:
    case GTEQ:
    case NEQ:
    case EQEQ:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LT:
        jj_consume_token(LT);
        p = AddSub();
                          e = new Lt(e,p);
        break;
      case LTEQ:
        jj_consume_token(LTEQ);
        p = AddSub();
                          e = new Lte(e,p);
        break;
      case GT:
        jj_consume_token(GT);
        p = AddSub();
                          e = new Gt(e,p);
        break;
      case GTEQ:
        jj_consume_token(GTEQ);
        p = AddSub();
                          e = new Gte(e,p);
        break;
      case NEQ:
        jj_consume_token(NEQ);
        p = AddSub();
                          e = new Neq(e,p);
        break;
      case EQEQ:
        jj_consume_token(EQEQ);
        p = AddSub();
                          e = new Eql(e,p);
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
      {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public Expr AddSub() throws ParseException {
                 Expr e, p;
    e = MulDiv();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ADD:
      case SUB:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ADD:
        jj_consume_token(ADD);
        p = MulDiv();
                                      e = new Add(e,p);
        break;
      case SUB:
        jj_consume_token(SUB);
        p = MulDiv();
                                      e = new Sub(e,p);
        break;
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
      {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public Expr MulDiv() throws ParseException {
                 Expr e, p;
    e = Atom();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MUL:
      case DIV:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MUL:
        jj_consume_token(MUL);
        p = Atom();
                                  e = new Mul(e,p);
        break;
      case DIV:
        jj_consume_token(DIV);
        p = Atom();
                                  e = new Div(e,p);
        break;
      default:
        jj_la1[7] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
      {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public Expr Atom() throws ParseException {
               Expr e; Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENT:
      t = jj_consume_token(IDENT);
                              {if (true) return new Id(t.image);}
      break;
    case INTLIT:
      t = jj_consume_token(INTLIT);
                              {if (true) return new IntLit(Integer.parseInt(t.image));}
      break;
    case OPEN:
      jj_consume_token(OPEN);
      e = Expr();
      jj_consume_token(CLOSE);
                              {if (true) return e;}
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public ParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[9];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x200000,0x100000,0xfc000,0xfc000,0xc00000,0xc00000,0x3000000,0x3000000,0x1280,};
   }

  /** Constructor with InputStream. */
  public Parser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Parser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Parser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Parser(ParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[26];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 9; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 26; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
