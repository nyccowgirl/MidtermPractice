public enum Major {
    ACCOUNTING("ACCTG"), COMPUTER_SCIENCE("COMP"), DRAMA("DRAM"),
    ENGINEERING("ENG"), FINANCE("FIN"), PSYCHOLOGY("PSYCH"),
    PHILOSOPHY("PHIL"), SCIENCE("SCI");

    private String abbreviation;

    Major(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
