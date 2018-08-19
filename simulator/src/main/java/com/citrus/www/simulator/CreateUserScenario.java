package com.citrus.www.simulator;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.consol.citrus.simulator.scenario.AbstractSimulatorScenario;
import com.consol.citrus.simulator.scenario.Scenario;
import com.consol.citrus.simulator.scenario.ScenarioDesigner;

@Scenario("CREATE_USER")
@RequestMapping(value = "/services/rest/v1/user", method = RequestMethod.POST)
public class CreateUserScenario extends AbstractSimulatorScenario {

    @Override
    public void run(ScenarioDesigner scenario) {
        scenario
            .http()
            .receive()
            .post()
            .payload(new ClassPathResource("templates/user-control.json"));

        scenario
            .http()
            .send()
            .response(HttpStatus.OK);
    }
}