@Configuration("CustomAuthenticatorSubsystemConfiguration")
public class CustomAuthenticatorSubsystemConfiguration {
    ...
    @Bean
    public FlowDefinitionRegistry customFlowRegistry() {
        final FlowDefinitionRegistryBuilder builder = new FlowDefinitionRegistryBuilder(applicationContext, flowBuilderServices);
        builder.setBasePath("classpath*:/webflow");
        builder.addFlowLocationPattern("/mfa-custom/*-webflow.xml");
        return builder.build();
    }

    @Bean
    public MultifactorAuthenticationProvider customAuthenticationProvider() {
        final CustomMultifactorAuthenticationProvider p = new CustomMultifactorAuthenticationProvider();
        p.setId("mfa-custom");
        return p;
    }

    @Bean
    public CasWebflowConfigurer customWebflowConfigurer() {
        return new CustomAuthenticatorWebflowConfigurer(
                flowBuilderServices,
                loginFlowDefinitionRegistry,
                customFlowRegistry());
    }
}
