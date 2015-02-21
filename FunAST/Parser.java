/* Generated By:JavaCC: Do not edit this line. Parser.java */
import ast.*;
public class Parser implements ParserConstants {
  public static void main(String[] args) {
     new Parser(System.in);
     try {
       Defn[] program = Top();
       new IndentOutput(System.out).indent(program);
     } catch (ParseException e) {
       System.out.println("Invalid syntax at ("
                          + token.beginColumn + ","
                          + token.beginLine + "), "
                          + token.image);
     } catch (TokenMgrError e) {
       System.out.println(e.getMessage());
     }
  }

//- Parser Functions --------------------------------------------------
  static final public Defn[] Top() throws ParseException {
                Defn[] program;
    program = Program(0);
    jj_consume_token(0);
    {if (true) return program;}
    throw new Error("Missing return statement in function");
  }

  static final public Defn[] Program(int soFar) throws ParseException {
                             Defn d; Defn[] program;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 2:
    case 12:
    case 13:
      d = Defn();
      program = Program(soFar+1);
      program[soFar] = d; {if (true) return program;}
      break;
    default:
      jj_la1[0] = jj_gen;
      {if (true) return new Defn[soFar];}
    }
    throw new Error("Missing return statement in function");
  }

  static final public Defn Defn() throws ParseException {
               Defn d;
    if (jj_2_1(3)) {
      d = Global();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 2:
      case 12:
      case 13:
        d = Fun();
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    {if (true) return d;}
    throw new Error("Missing return statement in function");
  }

  static final public Defn Global() throws ParseException {
                 Type t; VarIntro[] v;
    t = Type();
    v = Intros(0);
    jj_consume_token(1);
    {if (true) return new Globals(t, v);}
    throw new Error("Missing return statement in function");
  }

  static final public Defn Fun() throws ParseException {
              Type y = null; Token t; Formal[] f; Stmt s;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 2:
      jj_consume_token(2);
      break;
    case 12:
    case 13:
      y = Type();
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    t = jj_consume_token(IDENT);
    jj_consume_token(OPEN);
    f = Formals(0);
    jj_consume_token(CLOSE);
    s = Block();
    {if (true) return new Function(y, t.image ,f ,s);}
    throw new Error("Missing return statement in function");
  }

  static final public Formal[] Formals(int soFar) throws ParseException {
                               Type y; Token t; Formal[] f;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 12:
    case 13:
      y = Type();
      t = jj_consume_token(IDENT);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 3:
        jj_consume_token(3);
        f = Formals(soFar+1);
      f[soFar] = new Formal(y, t.image); {if (true) return f;}
        break;
      default:
        jj_la1[3] = jj_gen;
        ;
      }
     f = new Formal[soFar+1]; f[soFar] = new Formal(y, t.image); {if (true) return f;}
      break;
    default:
      jj_la1[4] = jj_gen;
      {if (true) return new Formal[0];}
    }
    throw new Error("Missing return statement in function");
  }

  static final public StmtExpr FunCall() throws ParseException {
                      Token t; Expr[] e;
    t = jj_consume_token(IDENT);
    jj_consume_token(OPEN);
    e = Exprs(0);
    jj_consume_token(CLOSE);
    {if (true) return new Call(t.image,e);}
    throw new Error("Missing return statement in function");
  }

  static final public Stmt Stmt() throws ParseException {
               Stmt s; StmtExpr m;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 4:
      s = Print();
      break;
    case 5:
      s = Return();
      break;
    case 6:
      s = While();
      break;
    case 7:
      s = Block();
      break;
    case 9:
      s = If();
      break;
    case 12:
    case 13:
      s = Decl();
      break;
    default:
      jj_la1[5] = jj_gen;
      if (jj_2_2(2)) {
        m = FunCall();
        jj_consume_token(1);
                                      {if (true) return new ExprStmt(m);}
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IDENT:
          s = StdAln();
          break;
        case 1:
          s = Empty();
          break;
        default:
          jj_la1[6] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
    {if (true) return s;}
    throw new Error("Missing return statement in function");
  }

  static final public Stmt Print() throws ParseException {
                Expr e;
    jj_consume_token(4);
    e = Expr();
    jj_consume_token(1);
    {if (true) return new   Print(e);}
    throw new Error("Missing return statement in function");
  }

  static final public Stmt Return() throws ParseException {
                 Expr e = null;
    jj_consume_token(5);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTLIT:
    case IDENT:
    case OPEN:
      e = Expr();
      break;
    default:
      jj_la1[7] = jj_gen;
      ;
    }
    jj_consume_token(1);
    {if (true) return new  Return(e);}
    throw new Error("Missing return statement in function");
  }

  static final public Stmt While() throws ParseException {
                Expr e; Stmt s;
    jj_consume_token(6);
    jj_consume_token(OPEN);
    e = Expr();
    jj_consume_token(CLOSE);
    s = Stmt();
    {if (true) return new While(e,s);}
    throw new Error("Missing return statement in function");
  }

  static final public Stmt Block() throws ParseException {
                Stmt[] stmts;
    jj_consume_token(7);
    stmts = Stmts(0);
    jj_consume_token(8);
    {if (true) return new Block(stmts);}
    throw new Error("Missing return statement in function");
  }

  static final public Stmt If() throws ParseException {
             Stmt s, l = null; Expr e;
    jj_consume_token(9);
    jj_consume_token(OPEN);
    e = Expr();
    jj_consume_token(CLOSE);
    s = Stmt();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 10:
      jj_consume_token(10);
      l = Stmt();
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
    {if (true) return new  If(e,s,l);}
    throw new Error("Missing return statement in function");
  }

  static final public Stmt Empty() throws ParseException {
    jj_consume_token(1);
    {if (true) return new Empty();}
    throw new Error("Missing return statement in function");
  }

  static final public Stmt[] Stmts(int soFar) throws ParseException {
                           Stmt s; Stmt[] stmts;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 1:
    case 4:
    case 5:
    case 6:
    case 7:
    case 9:
    case 12:
    case 13:
    case IDENT:
      s = Stmt();
      stmts = Stmts(soFar+1);
      stmts[soFar]=s; {if (true) return stmts;}
      break;
    default:
      jj_la1[9] = jj_gen;
      {if (true) return new Stmt[soFar];}
    }
    throw new Error("Missing return statement in function");
  }

  static final public Stmt Decl() throws ParseException {
               Type y; VarIntro[] intros;
    y = Type();
    intros = Intros(0);
    jj_consume_token(1);
    {if (true) return new Locals(y,intros);}
    throw new Error("Missing return statement in function");
  }

  static final public VarIntro Var() throws ParseException {
                  Token t; Expr e;
    t = jj_consume_token(IDENT);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 11:
      jj_consume_token(11);
      e = Expr();
                             {if (true) return new InitVarIntro(t.image,e);}
      break;
    default:
      jj_la1[10] = jj_gen;
      ;
    }
      {if (true) return new VarIntro(t.image);}
    throw new Error("Missing return statement in function");
  }

  static final public VarIntro[] Intros(int soFar) throws ParseException {
                                VarIntro[] intros; VarIntro v;
    v = Var();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 3:
      jj_consume_token(3);
      intros = Intros(soFar+1);
                                          intros[soFar] = v; {if (true) return intros;}
      break;
    default:
      jj_la1[11] = jj_gen;
      ;
    }
      intros = new VarIntro[soFar+1]; intros[soFar] = v; {if (true) return intros;}
    throw new Error("Missing return statement in function");
  }

  static final public Type Type() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 12:
      jj_consume_token(12);
                {if (true) return Type.INT;}
      break;
    case 13:
      jj_consume_token(13);
                {if (true) return Type.BOOLEAN;}
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public Stmt StdAln() throws ParseException {
                 Expr e; Token t;
    t = jj_consume_token(IDENT);
    jj_consume_token(11);
    e = Expr();
    jj_consume_token(1);
    {if (true) return new ExprStmt(new Assign(t.image, e));}
    throw new Error("Missing return statement in function");
  }

  static final public Expr[] Exprs(int soFar) throws ParseException {
                           Expr e; Expr [] exprs;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTLIT:
    case IDENT:
    case OPEN:
      e = Expr();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 3:
        jj_consume_token(3);
        exprs = Exprs(soFar+1);
                                         exprs[soFar] = e; {if (true) return exprs;}
        break;
      default:
        jj_la1[13] = jj_gen;
        ;
      }
      exprs = new Expr[soFar+1]; exprs[soFar] = e; {if (true) return exprs;}
      break;
    default:
      jj_la1[14] = jj_gen;
      {if (true) return new Expr[0];}
    }
    throw new Error("Missing return statement in function");
  }

  static final public Expr Expr() throws ParseException {
               Expr e; Token t;
    if (jj_2_3(2)) {
      t = jj_consume_token(IDENT);
      jj_consume_token(11);
      e = Expr();
                              {if (true) return new Assign(t.image, e);}
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTLIT:
      case IDENT:
      case OPEN:
        e = LogOr();
                              {if (true) return e;}
        break;
      default:
        jj_la1[15] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
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
      jj_la1[16] = jj_gen;
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
      jj_la1[17] = jj_gen;
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
        jj_la1[18] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[19] = jj_gen;
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
        jj_la1[20] = jj_gen;
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
        jj_la1[21] = jj_gen;
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
        jj_la1[22] = jj_gen;
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
        jj_la1[23] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
      {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public Expr Atom() throws ParseException {
               Expr e; Token t;
    if (jj_2_4(2)) {
      e = FunCall();
                              {if (true) return e;}
    } else {
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
        jj_la1[24] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  static private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  static private boolean jj_3R_5() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_7()) {
    jj_scanpos = xsp;
    if (jj_3R_8()) return true;
    }
    return false;
  }

  static private boolean jj_3R_4() {
    if (jj_scan_token(IDENT)) return true;
    if (jj_scan_token(OPEN)) return true;
    return false;
  }

  static private boolean jj_3_1() {
    if (jj_3R_3()) return true;
    return false;
  }

  static private boolean jj_3R_6() {
    if (jj_3R_9()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_10()) jj_scanpos = xsp;
    return false;
  }

  static private boolean jj_3_3() {
    if (jj_scan_token(IDENT)) return true;
    if (jj_scan_token(11)) return true;
    return false;
  }

  static private boolean jj_3R_9() {
    if (jj_scan_token(IDENT)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_11()) jj_scanpos = xsp;
    return false;
  }

  static private boolean jj_3_2() {
    if (jj_3R_4()) return true;
    return false;
  }

  static private boolean jj_3_4() {
    if (jj_3R_4()) return true;
    return false;
  }

  static private boolean jj_3R_10() {
    if (jj_scan_token(3)) return true;
    return false;
  }

  static private boolean jj_3R_8() {
    if (jj_scan_token(13)) return true;
    return false;
  }

  static private boolean jj_3R_3() {
    if (jj_3R_5()) return true;
    if (jj_3R_6()) return true;
    if (jj_scan_token(1)) return true;
    return false;
  }

  static private boolean jj_3R_11() {
    if (jj_scan_token(11)) return true;
    return false;
  }

  static private boolean jj_3R_7() {
    if (jj_scan_token(12)) return true;
    return false;
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
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[25];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x3004,0x3004,0x3004,0x8,0x3000,0x32f0,0x400002,0x2500000,0x400,0x4032f2,0x800,0x8,0x3000,0x8,0x2500000,0x2500000,0x0,0x0,0xf8000000,0xf8000000,0x0,0x0,0x0,0x0,0x2500000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x4,0x2,0x1,0x1,0x18,0x18,0x60,0x60,0x0,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[4];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

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
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
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
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
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
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
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
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
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
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      boolean exists = false;
      for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        exists = true;
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              exists = false;
              break;
            }
          }
          if (exists) break;
        }
      }
      if (!exists) jj_expentries.add(jj_expentry);
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[39];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 25; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 39; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
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

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 4; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
