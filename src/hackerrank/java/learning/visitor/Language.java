package hackerrank.java.learning.visitor;

interface LanguageAcceptor {
    String accept(LanguageVisitor visitor);
}

interface LanguageVisitor {
    String visit(JavaLanguage javaLanguage);
    String visit(PythonLanguage pythonLanguage);
}

class JavaLanguage implements LanguageAcceptor {
    private String javaDeveloper;

    public JavaLanguage(String javaDeveloper) {
        this.javaDeveloper = javaDeveloper;
    }

    public String getJavaDeveloper() {
        return javaDeveloper;
    }

    @Override
    public String accept(LanguageVisitor visitor) {
        return visitor.visit(this);
    }
}


class PythonLanguage implements LanguageAcceptor {
    private String pythonDev;
    public PythonLanguage(String pythonDev) {
        this.pythonDev = pythonDev;
    }

    public String getPythonDev() {
        return pythonDev;
    }

    @Override
    public String accept(LanguageVisitor visitor) {
        return visitor.visit(this);
    }
}

class LanguageVisitorImplementation implements LanguageVisitor {
    @Override
    public String visit(JavaLanguage javaLanguage) {
        return String.format("We dance like %s", javaLanguage.getJavaDeveloper());
    }

    @Override
    public String visit(PythonLanguage pythonLanguage) {
        return String.format("We dance like %s", pythonLanguage.getPythonDev());
    }
}

public class Language {
    public static void main(String[] args) {
        JavaLanguage j1 = new JavaLanguage("James Gosling");
        JavaLanguage j2 = new JavaLanguage("GilbertS");
        PythonLanguage p1 = new PythonLanguage("Guido van Rossum");
        LanguageAcceptor[] languages = new LanguageAcceptor[] { j1, j2, p1 };

        LanguageVisitorImplementation impl = new LanguageVisitorImplementation();
        for(LanguageAcceptor lang: languages) {
            // print out the developer
            System.out.println(lang.accept(impl));
        }
    }
}


