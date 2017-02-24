
public class Facebook2 {
	static class VersionCorrect {
		static boolean isVersionBad(int bad) {
			return true;
		}
	}
	
	int badVersion(int latestSuccessVer, int badVersion) {
		if (latestSuccessVer == badVersion - 1) {
			return latestSuccessVer;
		} else {
			int testVersion = (badVersion + latestSuccessVer) / 2;
			if (VersionCorrect.isVersionBad(testVersion)) {
				return badVersion(latestSuccessVer, testVersion);
			} else {
				return badVersion(testVersion, badVersion);
			}
		}
	}
	
	int badVersionNoRecusive(int latestSuccessVer, int badVersion) {
		if (latestSuccessVer == badVersion - 1) {
			return latestSuccessVer;
		} else {
			while (latestSuccessVer != badVersion - 1) {
				int testVersion = (badVersion + latestSuccessVer) / 2;
				if (VersionCorrect.isVersionBad(testVersion)) {
					badVersion = testVersion;
				} else {
					latestSuccessVer = testVersion;
				}
			}
			return latestSuccessVer;
		}
	}
}

