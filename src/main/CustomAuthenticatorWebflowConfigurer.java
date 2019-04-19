public class CustomAuthenticatorWebflowConfigurer extends AbstractCasMultifactorWebflowConfigurer {
    public static final String MFA_EVENT_ID = "mfa-custom";
    private final FlowDefinitionRegistry flowDefinitionRegistry;

    public CustomAuthenticatorWebflowConfigurer(FlowBuilderServices flowBuilderServices,
                                                FlowDefinitionRegistry loginFlowDefinitionRegistry,
                                                FlowDefinitionRegistry flowDefinitionRegistry) {
        super(flowBuilderServices, loginFlowDefinitionRegistry, flowDefinitionRegistry);
        this.flowDefinitionRegistry = flowDefinitionRegistry;
    }

    @Override
    protected void doInitialize() throws Exception {
        registerMultifactorProviderAuthenticationWebflow(getLoginFlow(),
                MFA_EVENT_ID, this.flowDefinitionRegistry);
    }
}
