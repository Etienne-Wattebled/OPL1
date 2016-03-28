
public class Launch {
	public static void main(String args[]) throws Exception {
		spoon.Launcher.main(new String[] {"-i","input","-p","com.etienne.wattebled.opl1.processors.nullpointer.SeparatesDeclarationInitialization"});
		spoon.Launcher.main(new String[] {"-i","spooned","-p","com.etienne.wattebled.opl1.processors.nullpointer.RepairsNullPointerExceptionCtVariableRead"});
		spoon.Launcher.main(new String[] {"-i","spooned","-p","com.etienne.wattebled.opl1.processors.nullpointer.RepairsArrayOutOfBoundExceptionCtArrayRead"});
	}
}
