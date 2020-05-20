package com.ibm.wala.cast.java.test;

import com.ibm.wala.cast.java.ipa.callgraph.JavaSourceAnalysisScope;
import com.ibm.wala.classLoader.Language;
import com.ibm.wala.ipa.callgraph.CallGraph;
import com.ibm.wala.ipa.callgraph.propagation.InstanceKey;
import com.ibm.wala.ipa.callgraph.propagation.PointerAnalysis;
import com.ibm.wala.types.Descriptor;
import com.ibm.wala.types.MethodReference;
import com.ibm.wala.types.TypeName;
import com.ibm.wala.types.TypeReference;
import com.ibm.wala.util.CancelException;
import com.ibm.wala.util.collections.Pair;
import com.ibm.wala.util.strings.Atom;
import java.io.IOException;
import org.junit.Test;

public abstract class Issue666Test extends IRTests {

  public Issue666Test(String projectName) {
    super(projectName);
  }

  @Test
  public void testPeekErrorCase() throws CancelException, IOException {
    Pair<CallGraph, PointerAnalysis<? extends InstanceKey>> result =
        runTest(singleTestSrc(), rtJar, simpleTestEntryPoint(), emptyList, true, null);

    MethodReference cm =
        MethodReference.findOrCreate(
            TypeReference.findOrCreate(
                JavaSourceAnalysisScope.SOURCE, TypeName.string2TypeName("LPeekErrorCase")),
            Atom.findOrCreateUnicodeAtom("start"),
            Descriptor.findOrCreateUTF8(Language.JAVA, "()V"));
  }
}