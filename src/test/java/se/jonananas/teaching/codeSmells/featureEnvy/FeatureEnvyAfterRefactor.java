package se.jonananas.teaching.codeSmells.featureEnvy;

public class FeatureEnvyAfterRefactor {

	ApplicationControllerImplBean applicationControllerImplBean = null;

	public void hasApplicationInAdmissionRoundVerifiedForSelection(Person person, Person existingPerson) {
		if (isPnrChanged(person, existingPerson)
				&& applicationControllerImplBean.hasApplicationInAdmissionRoundVerifiedForSelection(person.getKey())) {
			throw new NyaIllegalStateException(
					PersonErrorDetailCode.HAS_APPLICATION_IN_ADMISSIONROUND_VERIFIEDFORSELECTION,
					"Not possible to alias protect person when application in admissionround verified for selection");
		}
	}

	private boolean isPnrChanged(Person person, Person existingPerson) {
		// Logic checking if pnr in person and existingPerson are same
		return false;
	}
}
