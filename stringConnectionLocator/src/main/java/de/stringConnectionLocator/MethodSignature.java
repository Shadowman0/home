package de.stringConnectionLocator;

import java.util.Arrays;

public class MethodSignature {

	private String modifiers;
	private String returnType;
	private String name;
	private String[] parameters;

	public String getModifiers() {
		return modifiers;
	}

	public String getReturnType() {
		return returnType;
	}

	public String getName() {
		return name;
	}

	public String[] getParameters() {
		return parameters;
	}

	public void setModifiers(String modifiers) {
		this.modifiers = modifiers;

	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;

	}

	public void setName(String name) {
		this.name = name;

	}

	public void setParameters(String[] parameters) {
		this.parameters = parameters;

	}

	@Override
	public String toString() {
		return modifiers + " " + returnType + " " + name + "(" + Arrays.toString(parameters) + ")";
	}

	public boolean isGetter() {
		return name.startsWith("get");
	}

}
