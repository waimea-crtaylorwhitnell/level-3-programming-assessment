/**
 * =====================================================================
 * Programming Project for NCEA Level 3, Standard 91906
 * ---------------------------------------------------------------------
 * Project Name:   PROJECT NAME HERE
 * Project Author: PROJECT AUTHOR HERE
 * GitHub Repo:    GITHUB REPO URL HERE
 * ---------------------------------------------------------------------
 * Notes:
 * PROJECT NOTES HERE
 * =====================================================================
 */



import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    val app = App()         // Create the app model
    MainWindow(app)         // Create and show the UI, using the app model
}


/**
 * The application class (model)
 * This is the place where any application data should be
 * stored, plus any application logic functions
 */
class App() {
    var playerLocation =
    val connections = mutableListOf<Connection>()

    init {
        connections.add(Connection("There appears to be a door leading outside", "Central Yharnam"))
    }
}

class Connection(val description: String, val location: String) {

}

class Location(val name: String, val description: String, val connection: MutableList<Connection>) {
    override fun toString(): String {
        return "$name\n $description"
    }

}

/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow(val app: App) : JFrame(), ActionListener {

    // Fields to hold the UI elements
    private lateinit var titleLabel: JLabel
    private lateinit var infoLabel: JLabel
    private lateinit var locationSelection: JComboBox<Connection>
    private lateinit var fightButton: JButton
    private lateinit var checkButton: JButton
    private lateinit var itemButton: JButton
    private lateinit var lampButton: JButton

    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible

        updateView()                    // Initialise the UI
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Demo"
        contentPane.preferredSize = Dimension(1200, 700)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val titleFont = Font(Font.SANS_SERIF, Font.PLAIN, 32)
        val infoFont = Font(Font.SANS_SERIF, Font.PLAIN, 24)

        titleLabel = JLabel("Bloodborne")
        titleLabel.horizontalAlignment = SwingConstants.CENTER
        titleLabel.bounds = Rectangle(500, 44, 200, 48)
        titleLabel.font = titleFont
        add(titleLabel)

        infoLabel = JLabel(" ")
        infoLabel.border = BorderFactory.createLineBorder(Color(127, 127, 127), 5)
        infoLabel.horizontalAlignment = SwingConstants.CENTER
        infoLabel.bounds = Rectangle(130, 130, 940, 230)
        infoLabel.font = infoFont
        add(infoLabel)

        fightButton = JButton("Fight")
        fightButton.border = BorderFactory.createLineBorder(Color(127, 127, 127), 5)
        fightButton.horizontalAlignment = SwingConstants.CENTER
        fightButton.bounds = Rectangle(750, 401, 320, 60)
        fightButton.font = titleFont
        fightButton.addActionListener(this)
        add(fightButton)

        checkButton = JButton("Check")
        checkButton.border = BorderFactory.createLineBorder(Color(127, 127, 127), 5)
        checkButton.horizontalAlignment = SwingConstants.CENTER
        checkButton.bounds = Rectangle(750, 461, 320, 60)
        checkButton.font = titleFont
        checkButton.addActionListener(this)
        add(checkButton)

        itemButton = JButton("Item")
        itemButton.border = BorderFactory.createLineBorder(Color(127, 127, 127), 5)
        itemButton.horizontalAlignment = SwingConstants.CENTER
        itemButton.bounds = Rectangle(750, 521, 320, 60)
        itemButton.font = titleFont
        itemButton.addActionListener(this)
        add(itemButton)

        lampButton = JButton("Lamp")
        lampButton.border = BorderFactory.createLineBorder(Color(127, 127, 127), 5)
        lampButton.horizontalAlignment = SwingConstants.CENTER
        lampButton.bounds = Rectangle(750, 581, 320, 60)
        lampButton.font = titleFont
        lampButton.addActionListener(this)
        add(lampButton)
    }


    /**
     * Update the UI controls based on the current state
     * of the application model
     */
    fun updateView() {
        infoLabel.text =
    }

    /**
     * Handle any UI events (e.g. button clicks)
     * Usually this involves updating the application model
     * then refreshing the UI view
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
        }
    }

}

