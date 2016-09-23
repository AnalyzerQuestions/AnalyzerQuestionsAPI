package br.edu.ifpb.analyzerQuestions.util.data;

/**
 * Classe contém atributos contento listas de palavras especificas usadas para
 * ajudar na análise de uma caracteristica especifica em uma pergunta
 * 
 * @author franck
 *
 */
public class WordsUtils {

	/**
	 * Lista de palavras para ajudar na identificação de uma 
	 * pergunta duplicada.
	 */
	public final static String[] WORDS_DUPLICATE_CODE = {"pergunta duplicada", "já resolvido", "problema duplicado",
		"possível duplicação", "problema resolvido"};
	
	/**
	 * Lista de palavras que podem identificar um exemplo numa pergunta
	 */
	public final static String WORDS_CODE = "abstract,assert,boolean,break,byte,case,catch,char,class,const,default"
			+ "else,enum,extends,false,final,finally,float,for,goto"
			+ "if,implements,instanceof,int,long,native,new,null"
			+ "private,protected,public,return,short,static,strictfp,super,switch,synchronized"
			+ "this,throw,throws,transient,true,try,void,volatile,while,continue,equals,out,interger,"
			+ "valueof,super,get,set,|,||,&,&&,from. where, like,select,join";

	/**
	 * Lista de palavras que podem identificador presença de exemplo numa
	 * pergunta
	 */
	public final static String[] WORDS_EXAMPLES = { "por exemplo", "codigo", "segue o codigo", "ex:", "por exemplo:",
			"exemplo", "exemplo:" };

	/**
	 * Lista de palavras que podem ajudar na identificação de uma palavra
	 * factual
	 */
	public final static String[] WORDS_FACTOID = { "como", "onde", "quando", "qual" };

	/**
	 * Lista de palavras que rementem a logs de erros em perguntas publicadas.
	 */
	public final static String[] WORDS_LOG = { "at", "caused", "fatal", "grave" };

	public final static String[] WORDS_DETAILS = { "eclipse", "netbeans", "intelliJ idea Community edition", "intellij",
			"android studio", "enide studio", "bluej", "jedit", "jgrasp", "jsource", "jdeveloper", "drjava", "tomcat",
			"widfly", "glassfish", "jetty", "jboss", "ibm WebSphere", "red hat", "tmax", "fujitsu", "apache geronimo",
			"oracle", "cosminexus", "jdk", "java 1.5", "java 1.6", "java 1.7", "java 1.8"};

	/**
	 * Lista de palavras que podem identificar se a pergunta possui exigencia.
	 */
	public final static String[] WORDS_DEMANDING = { "urgente", "me mandem o codigo", "mandem o codigo",
			"mandem um exemplo", "estou com pressa", "mais rapido possivel", "sim eu sei", "mandem a resposta",
			"como posso fazer isso", "como faz isso", "respondam", "merda", "porra", "me ajudem, " + "codigo abaixo",
			"me ajudem codigo abaixo" };

	public final static String[] WORDS_INTEREST = { "tentei resolver", "busquei", "nao encontrei", "pesquisei",
			"encontrei", "nao achei", "ja procurei", "procurei", "fui atras", "já tentei", "varias formas", "http:",
			"link", };

	/**
	 * Lista de palavras que pode identificar presença de vocativo em um texto
	 */
	public final static String[] WORDS_VACATIVES = { "pessoal", "galera", "povo", "gente", "povao", "turma", "povareu",
			"grupo", "bando", "negrada", "individuos", "habitantes", "nacao", "publico", "populacao", "parentada",
			"povaleu", "todos", "terraqueos" };

	/**
	 * Lista de palavras que pode identificar agradecimento no texto
	 */
	public final static String[] WORDS_GREETINGS = { "vlw", "obrigado", "obrigado!", "obrigadu", "valeeu", "agradeço",
			"grato", "valeu", "agradecido" };

	/**
	 * Lista de palvras que podem iniciar uma estrutura de código java ou xml
	 */
	public final static String[] WORDS_INIT_COD = { "public", "private", "protected", "class", "abstract", "interface",
			"enum", "<", ".xhtml", ".xml", ".html", ".jsp", ".java" };

	/**
	 * Lista de palavras que podem finalizar uma estrutura de código java e xml
	 */
	public final static String[] WORDS_END_COD = { "}", "/>", ";" };

	public final static String[] HOMEWORK_WORDS = { "exercicio", "exercicios", "trabalho", "questoes", "questao",
			"faculdade", "escola", "aula" };

	/**
	 * Lista stop words do brasil
	 */
	public final static String[] BRAZILIAN_STOP_WORDS = { "será", "próprio", "pôde", "daqueles", "nesse", "vais",
			"empresas", "poderia", "está", "seus", "serão", "podem", "dessas", "nestas", "valor", "equipe", "poderiam",
			"foi", "sua", "só", "pontos", "desses", "nível", "vários", "especial", "podiam", "tem", "suas", "sob",
			"posso", "destas", "nove", "vêm", "pois", "com", "têm", "somos", "pouca", "destes", "novos", "vens",
			"estará", "polícia", "como", "ter", "sou", "primeira", "devem", "obra", "viagem", "eua", "política", "das",
			"teu", "talvez", "próximo", "dez", "obrigada", "vinte", "fará", "porém", "ela", "teve", "temos", "quatro",
			"dezanove", "obrigado", "vossa", "fato", "poucas", "eles", "tinha", "tivemos", "quê", "dezasseis", "oitava",
			"vossas", "fazendo", "povo", "em", "todos", "tiveram", "quer", "dezassete", "oitavo", "vosso", "fazia",
			"prazo", "era", "tu", "toda", "relação", "dezoito", "oito", "vossos", "preço", "estão", "alguns", "todo",
			"segundo", "diante", "onze", "zero", "feita", "preços", "eu", "aquelas", "trabalho", "sejam", "direito",
			"parece", "abaixo", "feitas", "presidente", "foram", "aqui", "tudo", "sim", "disse", "perto", "acerca",
			"feito", "primeiras", "há", "aquilo", "umas", "sistema", "doze", "pessoas", "acordo", "feitos", "problema",
			"muito", "às", "uns", "tal", "dúvida", "podia", "adiante", "problemas", "não", "bem", "ver", "tão",
			"embora", "põe", "afirma", "processo", "nós", "cada", "vez", "tenha", "então", "põem", "afirmou", "ficou",
			"produção", "ou", "contra", "além", "tinham", "eram", "ponto", "algumas", "filho", "produtos", "para", "da",
			"algumas", "três", "éramos", "porquê", "alguém", "por", "deve", "ano", "último", "és", "posição", "algum",
			"folha", "projeto", "qual", "diz", "anos", "vai", "possível", "alguma", "promeiro", "quando", "essas",
			"apenas", "vão", "estás", "possivelmente", "ambos", "próxima", "quem", "esses", "área", "vem", "esteja",
			"poucos", "ampla", "próximas", "sem", "estas", "assim", "vezes", "estejam", "primeiros", "amplas", "hora",
			"próximos", "a", "esteve", "atrás", "vindo", "estejamos", "própria", "amplo", "inflação", "até", "estive",
			"através", "vós", "estiver", "próprias", "amplos", "iniciar", "público", "depois", "estivemos", "bastante",
			"meses", "estivera", "próprios", "ante", "inicio", "quais", "dos", "estiveram", "cima", "mil",
			"estivéramos", "puderam", "apontar", "início", "quáis", "é", "estou", "cinco", "momento", "estiverem",
			"qualquer", "atras", "ir", "quantos", "ele", "fazer", "daquele", "nada", "estivermos", "quarta", "aumento",
			"irá", "quase", "entre", "dar", "nessa", "estivesse", "quarto", "banco", "quereis", "este", "fora", "dela",
			"nesta", "estivessem", "quero", "bilhões", "querem", "mais", "fosse", "delas", "neste", "estivéssemos",
			"questão", "boa", "janeiro", "queremas", "mas", "mesmo", "dele", "noite", "estiveste", "quinta", "boas",
			"jogo", "queres", "meu", "meus", "deles", "nova", "estivestes", "quinto", "bons", "quieto", "o", "minhas",
			"demais", "número", "faço", "quinze", "junto", "r", "os", "nossa", "dentro", "ontem", "favor", "sabe",
			"juros", "real", "pelo", "nossas", "dessa", "partir", "fazeis", "segunda", "justiça", "recursos", "que",
			"nossos", "desse", "pôde", "fazem", "sei", "lei", "região", "são", "onde", "desta", "podem", "fazemos",
			"seis", "ligado", "reportagem", "se", "outro", "dia", "pontos", "fazes", "sejamos", "caminho", "livro",
			"rio", "seu", "pelas", "dizem", "posso", "fôramos", "sendo", "campanha", "lo", "sabem", "também", "pode",
			"dizer", "pouca", "forem", "serei", "candidato", "maiorias", "saber", "tenho", "pouco", "duas", "primeira",
			"formos", "seremos", "média", "saúde", "um", "quanto", "enquanto", "próximo", "fôssemos", "seriam", "casa",
			"melhor", "semana", "uma", "sempre", "estamos", "quatro", "foste", "seríamos", "caso", "mercado", "setor",
			"você", "seria", "estar", "quê", "fostes", "sete", "central", "mesmas", "si", "à", "sobre", "estavam",
			"quer", "geral", "sétima", "centro", "mesmos", "agora", "te", "estávamos", "relação", "haja", "sétimo",
			"cerca", "milhões", "social", "antes", "teus", "exemplo", "segundo", "hajam", "sexta", "cidade",
			"ministério", "sociedade", "ao", "tive", "falta", "sejam", "hajamos", "sexto", "cinema", "ministro",
			"somente", "aos", "todas", "final", "sim", "hão", "sido", "coisas", "muita", "aquela", "tua", "forma",
			"sistema", "havemos", "sois", "comprido", "muitas", "sucursal", "aquele", "tuas", "fossem", "tal", "hei",
			"tanto", "congresso", "mulher", "sul", "aqueles", "vocês", "grandes", "tão", "houve", "tarde", "conhecido",
			"mundo", "tampouco", "as", "vos", "grupo", "tenha", "tém", "conta", "nacional", "tanta", "de", "ainda",
			"havia", "tinham", "houver", "tempo", "contudo", "naquelas", "tantas", "do", "ali", "hoje", "três",
			"houvera", "tendes", "corrente", "naqueles", "elas", "após", "horas", "último", "houverá", "tenham",
			"daquelas", "nenhum", "tendo", "essa", "bom", "lá", "vai", "houveram", "tenhamos", "depressa", "nesses",
			"tentar", "esse", "coisa", "lado", "vão", "houvéramos", "tens", "deputado", "nestes", "tentaram", "esta",
			"debaixo", "lhe", "vem", "houverão", "terá", "desligado", "ninguem", "tente", "estava", "desde", "lhes",
			"vezes", "houverei", "terão", "devagar", "ninguém", "tentei", "estes", "deverá", "local", "vindo",
			"houverem", "terceira", "devendo", "novas", "isso", "dois", "longe", "vós", "houveremos", "terceiro",
			"dever", "país", "tido", "isto", "faz", "lugar", "adeus", "houveria", "terei", "deverão", "países", "tipo",
			"já", "fez", "maior", "aí", "houveriam", "teremos", "deveria", "partido", "todavia", "fim", "maioria",
			"algo", "houveríamos", "teria", "deveriam", "passado", "trabalhar", "minha", "fomos", "meio", "apoio",
			"houvermos", "teriam", "devia", "paucas", "última", "na", "fui", "mês", "baixo", "houvesse", "teríamos",
			"deviam", "últimas", "nas", "grande", "meses", "breve", "houvessem", "tínhamos", "dias", "pegar", "últimos",
			"nem", "menos", "mil", "cá", "houvéssemos", "tiver", "dinheiro", "pequena", "no", "muitos", "momento",
			"catorze", "la", "tivera", "direita", "pequenas", "usa", "nos", "nome", "nada", "cedo", "logo", "tivéramos",
			"diretor", "pequeno", "usar", "nosso", "novo", "nessa", "cento", "mal", "tiverem", "disso", "pequenos",
			"vagarosamente", "num", "nunca", "nesta", "certamente", "máximo", "tivermos", "disto", "veja", "numa",
			"outra", "neste", "certeza", "menor", "tivesse", "dito", "perante", "vendo", "pela", "outras", "noite",
			"conselho", "mesma", "tivessem", "durante", "período", "verdade", "pelos", "outros", "nova", "custa",
			"naquela", "tivéssemos", "economia", "pesquisa", "verdadeiro", "porque", "parte", "número", "dá", "naquele",
			"tiveste", "econômica", "plano", "vida", "seja", "poder", "ontem", "dão", "nenhuma", "tivestes", "êle",
			"podendo", "vir", "ser", "primeiro", "partir", "daquela", "nessas", "treze", "empresa", "poderá", "zona",
			"ltda", "que", "tais", "direita", "esquerda", "ai", "cujo", "oi", "olá", "ola", "a", "b", "c", "d", "e",
			"f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "x", "w", "y", "z",
			"º", "ª", "â", "ã", "ï", "do",

			/**
			 * BRAZILIAN_INTERNET_ACRONYMNS
			 */
			"pd", "daqeles", "xta", "sta", "pdm", "vlr", "eqipe", "xpecial", "9", "cm", "tm", "primera", "obg", "#fato",
			"tds", "ti", "xtão", "tão", "td", "aqelas", "aki", "s", "aqilo", "pobrema", "mt", "tá", "pobremas", "n",
			"ñ", "bm", "p/", "qndo", "xtás", "possivelmnte", "qm", "vm", "xteja", "pocos", "sm", "xtas", "asim", "x",
			"vzs", "xtejam", "primeros", "hr", "hrs", "xteve", "detrás", "vndo", "xtejamos", "inté", "t+", "té",
			"xtive", "atrvés", "dpois", "dps", "xtivemos", "baxtante", "bastant", "mses", "ms", "xtivera", "qais", "ds",
			"xtiveram", "miu", "xtiveramos", "eh", "xtou", "extiveram", "qlqer", "qlqr", "detras", "i", "qntos", "fazê",
			"daqele", "nd", "xtivermos", "qse", "da", "xtivesse", "xte", "xtivessem", "qero", "qro", "qrem", "qerem",
			"+", "xtivéssemos", "qstão", "qstao", "noche", "xtiveste", "game", "qeres", "my", "xtivestes", "bns",
			"mnhas", "d+", "dmais", "jnto", "dntro", "ontm", "sab", "otro", "pntos", "diz", "poca", "poco", "qnto",
			"enqnto", "smpre", "xtamos", "vc", "xtavam", "qr", "cntro", "xtavamos", "ex.", "ex", "vcs", "v6", "6",
			"hove", "tard", "tampoco", "grup", "cnta", "d", "inda", "avia", "tnham", "ouver", "hover", "cntd",
			"naqelas", "tmpo", "hj", "overa", "hovera", "naqeles", "pos", "daqelas", "hoveram", "overam", "hoveramos",
			"overamos", "dbaxo", "debaxo", "hoverao", "overao", "ningem", "none", "so", "xtava", "exmplo", "overem",
			"hoverem", "hoveremos", "overemos", "fas", "xau", "bye", "cya", "tchau", "chau", "chauuuu", "k", "kk",
			"kkk", "kkkk", "kkkkk", "kkkkkk", "kkkkkkk", "overiam", "hoveriam", "end", "hoveriamos", "overiamos",
			"baxo", "ovesse", "hovesse", "grand", "utimo", "utimos", "ovessem", "hovessem", "nm", "-", "1000",
			"ovessemos", "hovessemos", "$", "max", "min", "bjs", "crteza", "crtz", "crtez", "part", "pq", "q", "kara",
			"cara", "brow", "pô", "pqp",

			"abs", "ae", "aew", "aff", "agr", "aham", "akela", "akele", "aki", "akilo", "algm", "amr", "ants", "aqelas",
			"aqilo", "art", "ashuashua", "asim", "ass", "ata", "avia", "aw", "aww", "axar", "axo", "babak", "balear",
			"baleiar", "bastant", "baxo", "baxtante", "bcta", "bgd", "bjs", "blz", "blza", "bm", "bns", "bora",
			"brinks", "brow", "btf", "bye", "c", "cara", "carai", "chau", "chauuuu", "cm", "cmg", "cmo", "cnta", "cntd",
			"cntro", "coe", "coeh", "cole", "coleh", "crlh", "crtez", "crteza", "crtz", "ctg", "ctz", "ctza", "cya",
			"d", "d+", "da", "daqelas", "daqele", "daqeles", "dbaxo", "debaxo", "dec", "detras", "dik", "diz", "dmais",
			"dntro", "dpois", "dps", "ds", "dsc", "dxar", "eh", "end", "enqnto", "enqto", "entaum", "eqipe", "esqec",
			"et", "ex", "exmplo", "extiveram", "fas", "fazr", "fcd", "fda", "fdac", "fik", "fikdik", "fikndo", "fikr",
			"fla", "flw", "fms", "fmz", "game", "gent", "gnt", "grand", "grup", "gst", "haha", "hehe", "hj", "hmmm",
			"hoho", "hove", "hover", "hovera", "hoveram", "hoveramos", "hoverao", "hoverem", "hoveremos", "hoveriam",
			"hoveriamos", "hovesse", "hovessem", "hovessemos", "hr", "hrs", "huahua", "i", "img", "inda", "ja", "jnto",
			"k", "kara", "karai", "kbeca", "kct", "kd", "kem", "kero", "kk", "kkk", "kkkk", "kkkkk", "kkkkkk",
			"kkkkkkk", "koe", "koeh", "kole", "koleh", "kra", "krak", "krk", "ksa", "kse", "lg", "lok", "lol", "magina",
			"max", "merec", "metad", "miga", "migo", "miguxa", "miguxo", "min", "miu", "mlk", "mlq", "mnhas", "mo",
			"mont", "mrda", "ms", "mses", "msg", "msm", "mt", "mto", "my", "n", "nah", "namo", "naqelas", "naqeles",
			"naum", "nd", "nda", "ne", "neh", "net", "ng", "ngm", "ningem", "ningm", "nive", "niver", "nqto", "nr",
			"num", "nunk", "nvd", "obg", "off", "og", "omg", "on", "ontm", "oq", "otra", "otro", "ouver", "overa",
			"overam", "overamos", "overao", "overem", "overemos", "overiam", "overiamos", "ovesse", "ovessem",
			"ovessemos", "pa", "parec", "part", "pblm", "pd", "pdm", "penc", "pera", "perai", "pk", "pls", "pntos",
			"po", "pobrema", "pobremas", "poca", "poco", "pocos", "pod", "poha", "poko", "pos", "possivelmnte", "pow",
			"pq", "pqp", "pra", "primera", "primeros", "pta", "putz", "q", "qais", "qd", "qdo", "qerem", "qeres",
			"qero", "qlqer", "qlqr", "qm", "qnd", "qndo", "qnto", "qntos", "qq", "qr", "qrem", "qro", "qse", "qstao",
			"qtd", "qtde", "qto", "qtos", "qts", "rs", "rsrs", "sab", "sdds", "sm", "smpre", "so", "soj", "sort",
			"spera", "sta", "t+", "tampoco", "tard", "tb", "tbm", "tc", "tchau", "td", "tds", "ti", "tm", "tmp", "tmpo",
			"tnc", "tnh", "tnham", "tnho", "to", "tow", "ta", "tao", "te", "utimo", "utimos", "v6", "vamo", "vc", "vcs",
			"vdd", "vlr", "vlw", "vm", "vndo", "vo", "vsf", "vtnc", "vzs", "x", "xata", "xato", "xau", "xpecial", "xta",
			"xtamos", "xtas", "xtava", "xtavam", "xtavamos", "xte", "xteja", "xtejam", "xtejamos", "xteve", "xtive",
			"xtivemos", "xtivera", "xtiveram", "xtiveramos", "xtivermos", "xtivesse", "xtivessem", "xtiveste",
			"xtivestes", "xtou", "xtas", "xtao", "n" };

	public static String[] getWordsCode() {
		String[] splited = WORDS_CODE.split(",");
		return splited;
	}
}
