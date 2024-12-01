package ua.edu.ucu.apps.Task3;

public class Main {
    public static void main(String[] args) {
        String website = "ucu.edu.ua";
        String domain = "ucu.edu.ua";
        String companyName = "Ukrainian Catholic University";

        Company company = CompanyFacade.getCompanyDetails(website, domain, companyName);
        if (company != null) {
            System.out.println(company);
        } else {
            System.out.println("Failed to fetch company details.");
        }
    }
}
