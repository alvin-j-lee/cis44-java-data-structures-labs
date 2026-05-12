/**
 * Represents a single loan applicant.
 *
 * This class stores the information that will be used by the decision engine,
 * including income, credit score, debt-to-income ratio, and employment history.
 */
public class Applicant {
    private int applicantId;
    private String name;
    private double income;
    private int creditScore;
    private double debtToIncomeRatio;
    private double employmentYears;

    /**
     * Creates a new Applicant object.
     *
     * @param applicantId unique ID used to store/search the applicant in the BST
     * @param name applicant's name
     * @param income applicant's yearly income
     * @param creditScore applicant's credit score
     * @param debtToIncomeRatio applicant's debt-to-income ratio
     * @param employmentYears number of years the applicant has been employed
     */
    public Applicant(int applicantId, String name, double income, int creditScore,
                     double debtToIncomeRatio, double employmentYears) {
        this.applicantId = applicantId;
        this.name = name;
        this.income = income;
        this.creditScore = creditScore;
        this.debtToIncomeRatio = debtToIncomeRatio;
        this.employmentYears = employmentYears;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public String getName() {
        return name;
    }

    public double getIncome() {
        return income;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public double getDebtToIncomeRatio() {
        return debtToIncomeRatio;
    }

    public double getEmploymentYears() {
        return employmentYears;
    }

    /**
     * Returns a readable String version of the applicant.
     * This is useful when printing applicant records during testing.
     */
    @Override
    public String toString() {
        return "Applicant{" +
                "applicantId=" + applicantId +
                ", name='" + name + '\'' +
                ", income=" + income +
                ", creditScore=" + creditScore +
                ", debtToIncomeRatio=" + debtToIncomeRatio +
                ", employmentYears=" + employmentYears +
                '}';
    }
}