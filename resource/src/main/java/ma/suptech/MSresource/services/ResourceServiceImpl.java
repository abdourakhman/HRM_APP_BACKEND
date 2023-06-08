package ma.suptech.MSresource.services;

import jakarta.transaction.Transactional;
import ma.suptech.MSresource.client.HumanRestClient;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {
    private final HumanRestClient humanRestClient;

    public ResourceServiceImpl(HumanRestClient humanRestClient) {
        this.humanRestClient = humanRestClient;
    }

    @Override
    public void initContract() {

    }

    @Override
    public void initProject() {

    }

    @Override
    public void initGoalSet() {

    }

    @Override
    public void initTimesheet() {

    }

    @Override
    public void initRequestTimeOff() {

    }
}
