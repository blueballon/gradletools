import groovy.swing.SwingBuilder
import javax.swing.*
import java.awt.*
import static java.awt.GridBagConstraints.*

mySwingBuilder = new groovy.swing.SwingBuilder()

frame = mySwingBuilder.frame(title: "yaGGr (groovy test variant) 0.01",
                             size:[650,600],
                             defaultCloseOperation:WindowConstants.EXIT_ON_CLOSE) {
    vbox {
        panel() {
        tabbedPane(tabLayoutPolicy: JTabbedPane.SCROLL_TAB_LAYOUT) {

            panel(name: 'Task to Run') {
                vbox {
                    panel() {   // upper button part
                        comboBox(items: ['Show all tasks',
                                         'Show only tasks with description',
                                         'Show only tasks matching the FAVorite keyword',
                                         'Show bookmarked tasks'],
                           actionPerformed: {println "combo (run) pressed"})
                        button("Refresh task list",
                           foreground:Color.BLUE,
                           actionPerformed: {println "refresh (run) pressed"})
                    }
                    panel {
                        scrollPane() {   // table part
                            table() {
                                tableModel() {
                                    propertyColumn(header: 'Task name', propertyName: 'RUNTASKNAME')
                                    propertyColumn(header: 'Task description', propertyName: 'RUNTASKDESC')
                                }
                            }
                        }
                    }
                }
            }   // end tab task to run


            panel(name: 'Properties') {
                scrollPane() {   // table part
                    table() {
                        tableModel() {
                            propertyColumn(header: 'Property name', propertyName: 'PROPNAME')
                            propertyColumn(header: 'Property value', propertyName: 'PROPVALUE')
                            propertyColumn(header: 'Is active?', propertyName: 'PROPACTIVE')
                        }
                    }
                }
            }   // end tab Properties


            panel(name: 'Task selection/deselection') {
                vbox {
                    panel() {   // upper button part
                        comboBox(items: ['Show all tasks',
                                         'Show only tasks with description',
                                         'Show only tasks matching the FAVorite keyword',
                                         'Show bookmarked tasks'],
                           actionPerformed: {println "combo (sel/desel) pressed"})
                        button("Refresh task list",
                           foreground:Color.BLUE,
                           actionPerformed: {println "refresh (sel/desel) pressed"})
                    }
                    panel {
                        scrollPane() {   // table part
                            table() {
                                tableModel() {
                                    propertyColumn(header: 'Task name', propertyName: 'SELTASKNAME')
                                    propertyColumn(header: 'Task description', propertyName: 'SELTASKDESC')
                                    propertyColumn(header: 'Is Active?', propertyName: 'SELTASKACTIVE')
                                }
                            }
                        }
                    }
                }
            }   // end tab task selection/deselection

            panel(name: 'Bookmarks') {
                scrollPane() {   // table part
                    table() {
                        tableModel() {
                            propertyColumn(header: 'Bookmark name', propertyName: 'BOOKMNAME')
                            propertyColumn(header: 'Command line', propertyName: 'BOOKMCMD')
                        }
                    }
                }
            }   // end tab Bookmarks


            panel(name: 'Settings') {
                def defaultInsets = [0,0,10,0]



                gridBagLayout()

                label (
                    text: "Gradle command: ",
                    constraints: gbc(gridx:0,gridy:0,fill:HORIZONTAL,insets:defaultInsets)
                )
                textField(
                    columns: 30,
                    constraints:gbc(gridx:1,gridy:0,gridwidth:REMAINDER,fill:HORIZONTAL,insets:defaultInsets)
                )

                label (
                    text: "FAVorite keyword regex: ",
                    constraints: gbc(gridx:0,gridy:1,fill:HORIZONTAL,insets:defaultInsets)
                )
                textField(
                    columns: 30,
                    constraints:gbc(gridx:1,gridy:1,gridwidth:REMAINDER,fill:HORIZONTAL,insets:defaultInsets)
                )

                label (
                    text: "Log Level: ",
                    constraints: gbc(gridx:0,gridy:2,fill:HORIZONTAL,insets:defaultInsets)
                )
                logLevGroup = buttonGroup(constraints: gbc(gridx:1,gridy:2,fill:HORIZONTAL,insets:defaultInsets));
                vbox {
                    radioButton(text:"Default", buttonGroup:logLevGroup, selected:true);
                    radioButton(text:"Quiet", buttonGroup:logLevGroup);
                    radioButton(text:"Info", buttonGroup:logLevGroup);
                    radioButton(text:"Debug", buttonGroup:logLevGroup);
                }

                label (
                    text: "Stack Trace: ",
                    constraints: gbc(gridx:0,gridy:3,fill:HORIZONTAL,insets:defaultInsets)
                )
                logLevGroup = buttonGroup(constraints: gbc(gridx:1,gridy:3,fill:HORIZONTAL,insets:defaultInsets));
                vbox {
                    radioButton(text:"None", buttonGroup:logLevGroup, selected:true);
                    radioButton(text:"Regular", buttonGroup:logLevGroup);
                    radioButton(text:"Full", buttonGroup:logLevGroup);
                }

            }  // end tab settings


        }  // end tabbed pane
        }  // end panel top

        panel(name: "Commandline",
              border: titledBorder('Command line:')) {
            hbox {
                textField(columns: 30) {

                }
                button("Run command",
                   foreground:Color.RED,
                   actionPerformed: {println "run pressed"})
                button("Bookmark...",
                   actionPerformed: {println "bookmark pressed"})
            }
        }


    }   // end master vbox
}
frame.visible = true
