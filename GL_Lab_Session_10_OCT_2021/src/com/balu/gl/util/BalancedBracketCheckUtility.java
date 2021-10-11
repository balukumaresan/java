package com.balu.gl.util;

import java.util.Stack;

/**
 * This utility find the balance of brackets in a passed String
 * 
 * @author baluk
 *
 */
public class BalancedBracketCheckUtility {

	public boolean checkBracketBalance(String input) {
		Stack<Character> stringStack = new Stack<>();

		for (int i = 0; i < input.length(); i++) {
			Character charcater = input.charAt(i);

			if ('(' == charcater || '{' == charcater || '[' == charcater) {
				stringStack.push(charcater);
				continue;
			}

			if (stringStack.isEmpty()) {
				return false;
			}

			if (')' == charcater || '}' == charcater || ']' == charcater) {
				Character stackCharacter = stringStack.pop();
				switch (charcater) {
				case '}': {
					if (stackCharacter == '[' || stackCharacter == '(') {
						return false;
					}
					break;
				}

				case ']': {
					if (stackCharacter == '{' || stackCharacter == '(') {
						return false;
					}
					break;
				}

				case ')': {
					if (stackCharacter == '[' || stackCharacter == '{') {
						return false;
					}
					break;
				}
				}
			}
		}

		return stringStack.isEmpty();
	}
}
