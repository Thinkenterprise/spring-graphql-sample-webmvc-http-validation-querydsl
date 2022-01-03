package io.spring.sample.graphql.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import graphql.scalars.ExtendedScalars;
import graphql.schema.idl.RuntimeWiring.Builder;
import graphql.validation.rules.OnValidationErrorStrategy;
import graphql.validation.rules.ValidationRules;
import graphql.validation.schemawiring.ValidationSchemaWiring;

@Configuration
public class GraphQLConfiguration implements RuntimeWiringConfigurer {

    @Override
    public void configure(Builder builder) {

        

        ValidationRules validationRules = ValidationRules.newValidationRules()
                                                         .onValidationErrorStrategy(OnValidationErrorStrategy.RETURN_NULL)
                                                        .build();

        ValidationSchemaWiring validationSchemaWiring = new  ValidationSchemaWiring(validationRules);


        builder.scalar(ExtendedScalars.Date); 
        builder.directiveWiring(validationSchemaWiring);
        
        
    }

}

