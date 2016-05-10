package se.jonananas.teaching.codeSmells.featureEnvy;

import java.util.List;

public class FeatureEnvyOriginal {
	ApplicationControllerImplBean applicationControllerImplBean = null;

	public void existsALockOnApplicationInOpenAdmissionRounds(Person person, Person existingPerson) {
		if (isPnrChanged(person, existingPerson)) {
			List<ApplicationKey> applicationsInOpenAdmissionRounds = applicationControllerImplBean
					.findAllApplicationsInOpenAdmissionRounds(existingPerson.getKey());
			for (ApplicationKey applicationKey : applicationsInOpenAdmissionRounds) {
				Application application = applicationControllerImplBean.fetchBy(applicationKey);
				if (application.isLocked()) {
					throw new NyaLockException(ApplicationErrorDetailCode.APPLICATION_LOCK_EXISTS_ON_A_APPLICATION,
							"A lock exists on a applicaiton");
				}
			}
		}
	}

	private boolean isPnrChanged(Person person, Person existingPerson) {
		// Logic checking if pnr in person and existingPerson are same
		return false;
	}
}
