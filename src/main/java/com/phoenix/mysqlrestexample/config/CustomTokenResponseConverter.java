package com.phoenix.mysqlrestexample.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.security.oauth2.core.OAuth2AccessToken.TokenType.BEARER;

public class CustomTokenResponseConverter implements Converter<Map<String, String>, OAuth2AccessTokenResponse> {
    private static final Set<String> TOKEN_RESPONSE_PARAMETER_NAMES = Stream.of(
            OAuth2ParameterNames.ACCESS_TOKEN,
            OAuth2ParameterNames.TOKEN_TYPE,
            OAuth2ParameterNames.EXPIRES_IN,
            OAuth2ParameterNames.REFRESH_TOKEN,
            OAuth2ParameterNames.SCOPE).collect(Collectors.toSet());

    @Override
    public OAuth2AccessTokenResponse convert(Map<String, String> tokenResponseParameters) {
        String accessToken = tokenResponseParameters.get(OAuth2ParameterNames.ACCESS_TOKEN);

        Set<String> scopes = Collections.emptySet();
        if (tokenResponseParameters.containsKey(OAuth2ParameterNames.SCOPE)) {
            String scope = tokenResponseParameters.get(OAuth2ParameterNames.SCOPE);
            scopes = Arrays.stream(StringUtils.delimitedListToStringArray(scope, ","))
                    .collect(Collectors.toSet());
        }

        Map<String, Object> additionalParameters = new HashMap<>();
        additionalParameters.put("key", "value");

        //...
        return OAuth2AccessTokenResponse.withToken(accessToken)
                .tokenType(BEARER)
                .expiresIn(300)
                .scopes(scopes)
                .refreshToken("refreshToken")
                .additionalParameters(additionalParameters)
                .build();
    }

}
