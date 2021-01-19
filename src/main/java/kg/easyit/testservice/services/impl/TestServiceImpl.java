package kg.easyit.testservice.services.impl;

import kg.easyit.testservice.models.dto.ResBody;
import kg.easyit.testservice.models.dto.SignatureClass;
import kg.easyit.testservice.models.dto.Status;
import kg.easyit.testservice.services.TestService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public ResBody getResult(Map<String, String> params) {
        TreeMap<String, String> map = new TreeMap<>(params);

        String text = map.keySet()
                .stream()
                .map(x-> x + "=" + map.get(x))
                .collect(Collectors.joining("&"));

        String sha256hex = DigestUtils.sha256Hex(text);

        ResBody resBody = new ResBody();
        resBody.setStatus(Status.SUCCESS);
        resBody.setResult(Arrays.asList(new SignatureClass(sha256hex)));

        return resBody;

    }
}
