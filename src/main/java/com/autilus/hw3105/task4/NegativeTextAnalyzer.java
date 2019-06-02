package com.autilus.hw3105.task4;

class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    private final String[] KEYWORDS = {":(", "=(", ":|"};

    @Override
    protected String[] getKeywords() {
        return KEYWORDS;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }

}
