package ua.edu.ucu.apps.Task3;

import java.io.IOException;

public class CompanyFacade {

    public static Company getCompanyDetails(String website, String domain, String companyName) {
        try {
            Company pdlInfo = PDLReader.getCompanyInfo(website);
            String openAiDescription = OpenAIReader.getCompanyDescription(companyName);
            Company brandfetchInfo = BrandfetchReader.getCompanyInfo(domain);

            String name = pdlInfo.getName() != null ? pdlInfo.getName() : brandfetchInfo.getName();
            String description = openAiDescription != null ? openAiDescription : pdlInfo.getDescription();
            String logo = brandfetchInfo.getLogo() != null ? brandfetchInfo.getLogo() : pdlInfo.getLogo();

            return new Company(name, description, logo);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
