package com.ydo4ki.memapi3;

/**
 * @author Sulphuris
 * @since 11.10.2024 12:59
 */
public abstract class Unchecked extends Throwable {
	private Unchecked() {}

	public abstract Error noreturn();
}
