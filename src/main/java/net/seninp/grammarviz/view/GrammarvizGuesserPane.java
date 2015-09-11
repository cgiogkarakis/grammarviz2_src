package net.seninp.grammarviz.view;

import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;
import net.miginfocom.swing.MigLayout;
import net.seninp.grammarviz.session.UserSession;

/**
 * Implements the parameter panel for GrammarViz.
 * 
 * @author psenin
 * 
 */
public class GrammarvizGuesserPane extends JPanel {

  private static final long serialVersionUID = -941188995659753923L;

  // The labels
  //
  private static final JLabel SAMPLING_INTERVAL_LABEL = new JLabel("Sampling interval bounds:");
  private static final JLabel WINDOW_BOUND_LABEL = new JLabel("Window bounds:");
  private static final JLabel PAA_BOUND_LABEL = new JLabel("PAA bounds:");
  private static final JLabel ALPHABET_BOUND_LABEL = new JLabel("Alphabet bounds:");

  // and their UI widgets
  //
  private static final JTextField intervalStartField = new JFormattedTextField(getFormatter());
  private static final JTextField intervalEndField = new JFormattedTextField(getFormatter());

  private static final JTextField windowMinField = new JFormattedTextField(getFormatter());
  private static final JTextField windowMaxField = new JFormattedTextField(getFormatter());
  private static final JTextField windowIncrement = new JFormattedTextField(getFormatter());

  private static final JTextField paaMinField = new JFormattedTextField(getFormatter());
  private static final JTextField paaMaxField = new JFormattedTextField(getFormatter());
  private static final JTextField paaIncrement = new JFormattedTextField(getFormatter());

  private static final JTextField alphabetMinField = new JFormattedTextField(getFormatter());
  private static final JTextField alphabetMaxField = new JFormattedTextField(getFormatter());
  private static final JTextField alphabetIncrement = new JFormattedTextField(getFormatter());

  /**
   * Constructor.
   * 
   * @param userSession
   */
  public GrammarvizGuesserPane(UserSession userSession) {

    super(new MigLayout("fill", "[][fill,grow][fill,grow][fill,grow]", "[grow]"));

    this.add(SAMPLING_INTERVAL_LABEL, "span 2");
    this.add(intervalStartField);
    this.add(intervalEndField, "wrap");

    this.add(WINDOW_BOUND_LABEL);
    this.add(windowMinField);
    this.add(windowMaxField);
    this.add(windowIncrement, "wrap");

    this.add(PAA_BOUND_LABEL);
    this.add(paaMinField);
    this.add(paaMaxField);
    this.add(paaIncrement, "wrap");

    this.add(ALPHABET_BOUND_LABEL);
    this.add(alphabetMinField);
    this.add(alphabetMaxField);
    this.add(alphabetIncrement, "wrap");

    setValues(userSession);

  }

  private void setValues(UserSession userSession) {

    intervalStartField.setText(Integer.valueOf(userSession.samplingStart).toString());
    intervalEndField.setText(Integer.valueOf(userSession.samplingEnd).toString());

    windowMinField.setText(Integer.valueOf(userSession.boundaries[0]).toString());
    windowMaxField.setText(Integer.valueOf(userSession.boundaries[1]).toString());
    windowIncrement.setText(Integer.valueOf(userSession.boundaries[2]).toString());

    paaMinField.setText(Integer.valueOf(userSession.boundaries[3]).toString());
    paaMaxField.setText(Integer.valueOf(userSession.boundaries[4]).toString());
    paaIncrement.setText(Integer.valueOf(userSession.boundaries[5]).toString());

    alphabetMinField.setText(Integer.valueOf(userSession.boundaries[6]).toString());
    alphabetMaxField.setText(Integer.valueOf(userSession.boundaries[7]).toString());
    alphabetIncrement.setText(Integer.valueOf(userSession.boundaries[8]).toString());

  }

  private static NumberFormatter getFormatter() {
    NumberFormat format = NumberFormat.getInstance();
    NumberFormatter formatter = new NumberFormatter(format);
    formatter.setValueClass(Integer.class);
    formatter.setMinimum(0);
    formatter.setMaximum(Integer.MAX_VALUE);
    // If you want the value to be committed on each keystroke instead of focus lost
    formatter.setCommitsOnValidEdit(true);
    return formatter;
  }

}
