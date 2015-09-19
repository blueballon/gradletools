import groovy.swing.SwingBuilder
import javax.swing.*
import java.awt.*

mySwingBuilder = new groovy.swing.SwingBuilder()

frame = mySwingBuilder.frame(title: "Klicken",
                             size:[200,100],
                             defaultCloseOperation:WindowConstants.EXIT_ON_CLOSE) {
    panel() {
        tabbedPane(tabLayoutPolicy: JTabbedPane.SCROLL_TAB_LAYOUT) {
            panel(name: 'Task to Run') {
                vbox {
                    panel() {   // upper button part
                        comboBox(items: ['Show all tasks',
                                         'Show only tasks with description',
                                         'Show only tasks matching the FAVorite keyword',
                                         'Show bookmarked tasks'],
                           actionPerformed: {println "combopressed"})
                        button("Refresh task list",
                           foreground:Color.BLUE,
                           actionPerformed: {println "refresh pressed"})
                    }
                    panel {
                        scrollPane() {   // table part
                            table() {
                                tableModel() {
                                    propertyColumn(header: 'Task', propertyName: 'TASKNAME')
                                    propertyColumn(header: 'Description', propertyName: 'DESCRIPTION')
                                }
                            }
                        }
                    }
                }
            }   // end tab task to run


            panel(name: 'Properties') {

            }   // end tab Properties


            panel(name: 'Task selection/deselection') {

            }   // end tab task selection/deselection



            panel(name: 'Settings') {

            }  // end tab settings


        }  // end tabbed pane
        frame(name: "Command line") {

        }

    }   // end master panel
}
frame.visible = true
