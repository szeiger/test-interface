package org.scalasbt.testing.adapt;

import java.util.ArrayList;

import org.scalatools.testing.AnnotatedFingerprint;
import org.scalatools.testing.Fingerprint;
import org.scalatools.testing.SubclassFingerprint;

/**
 * An adapter from a new Fingerprint to an old one, to simplify the
 * implementation of test frameworks which implement both, the old and
 * the new test interface.
 */
public final class ReverseFingerprintAdapter {
  private ReverseFingerprintAdapter() {}

  /**
   * Adapt an array of new fingerprints to the old interface.
   * 
   * @return An old <code>Fingerprint</code>, or <code>null</code> if the new
   *         <code>Fingerprint</code> cannot be adapted for use with the old interface.
   */
  public static Fingerprint adapt(org.scalasbt.testing.Fingerprint fp) {
    if(fp instanceof org.scalasbt.testing.AnnotatedFingerprint) {
      final org.scalasbt.testing.AnnotatedFingerprint afp = (org.scalasbt.testing.AnnotatedFingerprint)fp;
      return new AnnotatedFingerprint() {
        @Override public boolean isModule() { return afp.isModule(); }
        @Override public String annotationName() { return afp.annotationName(); }
      };
    } else if(fp instanceof org.scalasbt.testing.SubclassFingerprint) {
      final org.scalasbt.testing.SubclassFingerprint sfp = (org.scalasbt.testing.SubclassFingerprint)fp;
      return new SubclassFingerprint() {
        @Override public String superClassName() { return sfp.superclassName(); }
        @Override public boolean isModule() { return sfp.isModule(); }
      };
    } else return null;
  }

  /**
   * Adapt an array of new fingerprints to the old interface.
   */
  public static Fingerprint[] adapt(org.scalasbt.testing.Fingerprint[] fps) {
    ArrayList<Fingerprint> l = new ArrayList<Fingerprint>(fps.length);
    for(int i=0; i<fps.length; i++) {
      Fingerprint fp = adapt(fps[i]);
      if(fp != null) l.add(fp);
    }
    return l.toArray(new Fingerprint[l.size()]);
  }
}
