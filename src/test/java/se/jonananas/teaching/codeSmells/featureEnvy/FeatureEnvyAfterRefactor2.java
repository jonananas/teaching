package se.jonananas.teaching.codeSmells.featureEnvy;

public class FeatureEnvyAfterRefactor2 {

	ApplicationControllerImplBean applicationCIB = null;

	public void hasApplicationInAdmissionRoundVerifiedForSelection(Person person, Person existingPerson) {
		if (person.hasSamePnrAs(existingPerson)
				&& applicationCIB.hasApplicationInAdmissionRoundVerifiedForSelection(person.getKey())) {
			throw new NyaIllegalStateException(
					PersonErrorDetailCode.HAS_APPLICATION_IN_ADMISSIONROUND_VERIFIEDFORSELECTION,
					"Not possible to alias protect person when application in admissionround verified for selection");
		}
	}
}
