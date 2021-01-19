package kg.easyit.testservice.services;

import kg.easyit.testservice.models.dto.ResBody;

import java.util.Map;

public interface TestService {

    ResBody getResult(Map<String, String> params);
}
