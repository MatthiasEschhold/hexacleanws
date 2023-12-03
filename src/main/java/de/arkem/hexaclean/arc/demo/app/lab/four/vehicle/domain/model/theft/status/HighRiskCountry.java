package de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.theft.status;

public record HighRiskCountry(String value) {
    private static final String COUNTRY_CODE_PATTERN = "[A-Z]{2}-[a-z]{2}";
    public HighRiskCountry {
        validateHighRiskCountry(value);
    }

    private void validateHighRiskCountry(String value) {
        if (!isHighRiskCountryValid(value)) {
            throw new IllegalStateException("high risk country is not valid");
        }
    }

    private boolean isHighRiskCountryValid(String value) {
        return value != null && value.matches(COUNTRY_CODE_PATTERN);
    }
}
