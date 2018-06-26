/**
 * This class file was automatically generated by jASN1 v1.10.0 (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.compile_test;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import org.openmuc.jasn1.ber.*;
import org.openmuc.jasn1.ber.types.*;
import org.openmuc.jasn1.ber.types.string.*;


public class MyChoice implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public byte[] code = null;
	public MyChoice2 myChoice2 = null;
	public BerBoolean myboolean = null;
	
	public MyChoice() {
	}

	public MyChoice(byte[] code) {
		this.code = code;
	}

	public MyChoice(MyChoice2 myChoice2, BerBoolean myboolean) {
		this.myChoice2 = myChoice2;
		this.myboolean = myboolean;
	}

	public int encode(OutputStream reverseOS) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			return code.length;
		}

		int codeLength = 0;
		if (myboolean != null) {
			codeLength += myboolean.encode(reverseOS, true);
			return codeLength;
		}
		
		if (myChoice2 != null) {
			codeLength += myChoice2.encode(reverseOS);
			return codeLength;
		}
		
		throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
	}

	public int decode(InputStream is) throws IOException {
		return decode(is, null);
	}

	public int decode(InputStream is, BerTag berTag) throws IOException {

		int codeLength = 0;
		BerTag passedTag = berTag;

		if (berTag == null) {
			berTag = new BerTag();
			codeLength += berTag.decode(is);
		}

		myChoice2 = new MyChoice2();
		int choiceDecodeLength = myChoice2.decode(is, berTag);
		if (choiceDecodeLength != 0) {
			return codeLength + choiceDecodeLength;
		}
		else {
			myChoice2 = null;
		}

		if (berTag.equals(BerBoolean.tag)) {
			myboolean = new BerBoolean();
			codeLength += myboolean.decode(is, false);
			return codeLength;
		}

		if (passedTag != null) {
			return 0;
		}

		throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS);
		code = reverseOS.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		if (myChoice2 != null) {
			sb.append("myChoice2: ");
			myChoice2.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (myboolean != null) {
			sb.append("myboolean: ").append(myboolean);
			return;
		}

		sb.append("<none>");
	}

}

