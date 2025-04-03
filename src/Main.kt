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
    public val locations = mutableListOf<Location>()
    var playerLocation = 0
    var lastLocation = 0

    // location indices
    val firstFloorSickroom = 0
    val centralYharnam = 1
    val greatBridge = 2
    val tombOfOedon = 3
    val cathedralWard = 4
    val oldYharnam = 5
    val churchOfTheGoodChalice = 6
    val healingChurchWorkshop = 7
    val abandonedOldWorkshop = 8
    val lowerCathedralWard = 9
    val greatCathedral = 10
    val hemwickCharnelLane = 11
    val witchsAbode = 12
    val forbiddenWoods = 13
    val forbiddenGrave = 14
    val byrgenwerth = 15
    val moonsideLake = 16
    val hypogeanGaol = 17
    val yahargulUnseenVillage = 18
    val yahargulChapel = 19
    val graveyardOfTheDarkbeast = 20
    val adventPlaza = 21
    val upperCathedralWard = 22
    val lumeflowerGardens = 23
    val altarOfDespair = 24
    val lectureBuilding = 25
    val nightmareFrontier = 26
    val amygdalasChamber = 27
    val lectureBuildingSecondFloor = 28
    val nightmareOfMensis = 29
    val mergosLoftBase = 30
    val mergosLoftMiddle = 31
    val wetNursesLunarium = 32
    val forsakenCainhurstCastle = 33
    val logariusSeat = 34
    val vilebloodQueensChamber = 35
    val huntersNightmare = 36
    val nightmareGrandCathedral = 37
    val nightmareChurch = 38
    val undergroundCorpsePile = 39
    val undergroundCell = 40
    val surgeryAltar = 41
    val researchHall = 42
    val lumenwoodGarden = 43
    val astralClocktower = 44
    val fishingHamlet = 45
    val lighthouseHut = 46
    val coast = 47
    val huntersDream = 48

    init {
        locations.add(Location("1st Floor Sickroom", null, "Forbidden Woods, and Central Yharnam")) // 0
        locations.add(Location("Central Yharnam", null, "1st Floor Sickroom, Great Bridge, Tomb Of Oedon")) // 1
        locations.add(Location("Great Bridge", null, "Central Yharnam")) // 2
        locations.add(Location("Tomb Of Oedon", null, "Central Yharnam, and Cathedral Ward")) // 3
        locations.add(Location("Cathedral Ward", null, "Tomb Of Oedon, Old Yharnam, Healing Church Workshop, Abandoned Old Workshop, Lower Cathedral Ward, Grand Cathedral, Hemwick Charnel Lane, Forbidden Woods, Moonside Lake, Yahar'gul, Unseen Village, Lecture Building, and Hunter's Nightmare")) // 4
        locations.add(Location("Old Yharnam", null, "Cathedral Ward, Church Of The Good Chalice, and Graveyard Of The Darkbeast")) // 5
        locations.add(Location("Church Of The Good Chalice", null, "Old Yharnam")) // 6
        locations.add(Location("Healing Church Workshop", null, "Cathedral Ward, Abandoned Old Workshop, Lower Cathedral Ward, and Upper Cathedral Ward")) // 7
        locations.add(Location("Abandoned Old Workshop", null, "Cathedral Ward, Healing Church Workshop, and Lower Cathedral Ward")) // 8
        locations.add(Location("Lower Cathedral Ward", null, "Cathedral Ward, Healing Church Workshop, and Abandoned Old Workshop")) // 9
        locations.add(Location("Great Cathedral", null, "Cathedral Ward")) // 10
        locations.add(Location("Hemwick Charnel Lane", null, "Cathedral Ward, Witch's Abode, and Forsaken Cainhurst Castle")) // 11
        locations.add(Location("Witch's Abode", null, "Hemwick Charnel Lane")) // 12
        locations.add(Location("Forbidden Woods", null, "1st Floor Sickroom, Cathedral Ward, and Forbidden Grave")) // 13
        locations.add(Location("Forbidden Grave", null, "Forbidden Woods, and Byrgenwerth")) //14
        locations.add(Location("Byrgenwerth", null, "Forbidden Grave, and Moonside Lake")) //15
        locations.add(Location("Moonside Lake", null, "Byrgenwerth, Cathedral Ward, and Yahar'gul Unseen Village")) //16
        locations.add(Location("Hypogean Gaol", null, "Yahar'gul Chapel, Graveyard Of The Darkbeast, and Advent Plaza")) // 17
        locations.add(Location("Yahar'gul, Unseen Village", null, "Cathedral Ward, Moonside Lake, Advent Plaza, Nightmare Of Mensis")) // 18
        locations.add(Location("Yahar'gul Chapel", null, "Graveyard Of The Darkbeast, Yahar'gul Unseen Village, Advent Plaza, and Hypogean Gaol")) // 19
        locations.add(Location("Graveyard Of The Darkbeast", null, "Hypogean Gaol, Yahar'gul Chapel, and Old Yharnam")) // 20
        locations.add(Location("Advent Plaza", null, "Yahar'gul Unseen Village, Lecture Building 2nd Floor, Hypogean Gaol, and Yahar'gul Chapel")) // 21
        locations.add(Location("Upper Cathedral Ward", null, "Healing Church Workshop, and Lumenflower Gardens")) // 22
        locations.add(Location("Lumenflower Gardens", null, "Upper Cathedral Ward, and Altar Of Despair")) // 23
        locations.add(Location("Altar Of Despair", null, "Lumenflower Gardens")) // 24
        locations.add(Location("Lecture Building", null, "Nightmare Frontier, Lecture Building 2nd Floor, and Cathedral Ward")) // 25
        locations.add(Location("Nightmare Frontier", null, "Lecture Building, and Amygdala's Chamber")) // 26
        locations.add(Location("Amygdala's Chamber", null, "Nightmare Frontier")) // 27
        locations.add(Location("Lecture Building 2nd Floor", null, "Lecture Building, Nightmare Of Mensis, and Advent Plaza")) // 28
        locations.add(Location("Nightmare Of Mensis", null, "Yahar'gul Unseen Village, Lecture Building 2nd Floor, Mergo's Loft Base, and Mergo's Loft Middle")) // 29
        locations.add(Location("Mergo's Loft Base", null, "Nightmare Of Mensis, and Mergo's Loft Middle")) // 30
        locations.add(Location("Mergo's Loft Middle", null, "Nightmare Of Mensis, Mergo's Loft Base, and Wet Nurse's Lunarium")) // 31
        locations.add(Location("Wet Nurse's Lunarium", null, "Mergo's Loft Middle")) // 32
        locations.add(Location("Forsaken Castle Cainhurst", null, "Hemwick Charnel Lane, and Logarius' Seat")) // 33
        locations.add(Location("Logarius' Seat", null, "Forsaken Cainhurst Castle, and Vileblood Queen's Chamber")) // 34
        locations.add(Location("Vileblood Queen's Chamber", null, "Logarius' Seat")) // 35
        locations.add(Location("Hunter's Nightmare", null, "Cathedral Ward, Nightmare Church, Nightmare Grand Cathedral, and Underground Corpse Pile")) // 36
        locations.add(Location("Nightmare Grand Cathedral", null, "Hunter's Nightmare")) // 37
        locations.add(Location("Nightmare Church", null, "Hunter's Nightmare, and Underground Corpse Pile")) // 38
        locations.add(Location("Underground Corpse Pile", null, "Hunter's Nightmare, Nightmare Church, and Underground Cell")) // 39
        locations.add(Location("Underground Cell", null, "Underground Corpse Pile, and Surgery Altar")) // 40
        locations.add(Location("Surgery Altar", null, "Underground Cell, and Research Hall")) // 41
        locations.add(Location("Research Hall", null, "Surgery Altar, and Lumenwood Garden")) // 42
        locations.add(Location("Lumenwood Garden", null, "Research Hall, and Astral Clocktower")) // 43
        locations.add(Location("AstralClocktower", null, "Lumenwood Garden, and Fishing Hamlet")) // 44
        locations.add(Location("Fishing Hamlet", null, "Astral Clocktower, Lighthouse Hut, and Coast")) // 45
        locations.add(Location("Lighthouse Hut", null, "Coast, and Fishing Hamlet")) // 46
        locations.add(Location("Coast", null, "Fishing Hamlet, and Lighthouse Hut")) // 47
        locations.add(Location("Hunter's Dream", null, "$lastLocation")) // 48
    }

    fun lamp() {
        lastLocation = playerLocation
        playerLocation = 48
    }
}

class Location(val name: String, val description: String?, val connections: String) {
    override fun toString(): String {
        return "<html>$name<br/>$description<br/>The possible way(s) forwards are $connections.</html>"
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
    private lateinit var textEntry: JTextField
    private lateinit var areaButton: JButton
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

        textEntry = JTextField()
        textEntry.border = BorderFactory.createLineBorder(Color(127, 127, 127), 5)
        textEntry.bounds = Rectangle(130, 380, 600, 60)
        textEntry.font = infoFont
        add(textEntry)

        areaButton = JButton("Confirm")
        areaButton.border = BorderFactory.createLineBorder(Color(127, 127, 127), 5)
        areaButton.horizontalAlignment = SwingConstants.CENTER
        areaButton.bounds = Rectangle(130, 460, 600, 60)
        areaButton.font = titleFont
        areaButton.addActionListener(this)
        add(areaButton)

        fightButton = JButton("Fight")
        fightButton.border = BorderFactory.createLineBorder(Color(127, 127, 127), 5)
        fightButton.horizontalAlignment = SwingConstants.CENTER
        fightButton.bounds = Rectangle(750, 380, 320, 60)
        fightButton.font = titleFont
        fightButton.addActionListener(this)
        add(fightButton)

        checkButton = JButton("Check")
        checkButton.border = BorderFactory.createLineBorder(Color(127, 127, 127), 5)
        checkButton.horizontalAlignment = SwingConstants.CENTER
        checkButton.bounds = Rectangle(750, 440, 320, 60)
        checkButton.font = titleFont
        checkButton.addActionListener(this)
        add(checkButton)

        itemButton = JButton("Item")
        itemButton.border = BorderFactory.createLineBorder(Color(127, 127, 127), 5)
        itemButton.horizontalAlignment = SwingConstants.CENTER
        itemButton.bounds = Rectangle(750, 500, 320, 60)
        itemButton.font = titleFont
        itemButton.addActionListener(this)
        add(itemButton)

        lampButton = JButton("Lamp")
        lampButton.border = BorderFactory.createLineBorder(Color(127, 127, 127), 5)
        lampButton.horizontalAlignment = SwingConstants.CENTER
        lampButton.bounds = Rectangle(750, 560, 320, 60)
        lampButton.font = titleFont
        lampButton.addActionListener(this)
        add(lampButton)
    }


    /**
     * Update the UI controls based on the current state
     * of the application model
     */
    fun updateView() {
        infoLabel.text = app.locations[app.playerLocation].toString()
    }

    /**
     * Handle any UI events (e.g. button clicks)
     * Usually this involves updating the application model
     * then refreshing the UI view
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            areaButton, textEntry -> {
                if (textEntry.text.isNotEmpty()) {
                    when (app.playerLocation) {
                        0 -> {
                            when (textEntry.text.lowercase()) {
                                "central yharnam" -> {
                                    app.playerLocation = 1
                                }
                                "forbidden woods" -> {
                                    app.playerLocation = 13
                                }
                            }
                        }
                        1 -> {
                            when (textEntry.text.lowercase()) {
                                "1st floor sickroom" -> {
                                    app.playerLocation = 0
                                }
                                "great bridge" -> {
                                    app.playerLocation = 2
                                }
                                "tomb of oedon" -> {
                                    app.playerLocation = 3
                                }
                            }
                        }
                        2 -> {
                            when (textEntry.text.lowercase()) {
                                "central yharnam" -> {
                                    app.playerLocation = 1
                                }
                            }
                        }
                        3 -> {
                            when (textEntry.text.lowercase()) {
                                "central yharnam" -> {
                                    app.playerLocation = 1
                                }
                                "cathedral ward" -> {
                                    app.playerLocation = 4
                                }
                            }
                        }
                        4 -> {
                            when (textEntry.text.lowercase()) {
                                "tomb of oedon" -> {
                                    app.playerLocation = 3
                                }
                                "hunter's nightmare" -> {
                                    app.playerLocation = 36
                                }
                                "healing church workshop" -> {
                                    app.playerLocation = 7
                                }
                                "lower cathedral ward" -> {
                                    app.playerLocation = 9
                                }
                                "hemwick charnel lane" -> {
                                    app.playerLocation = 11
                                }
                                "grand cathedral" -> {
                                    app.playerLocation = 10
                                }
                                "abandoned old workshop" -> {
                                    app.playerLocation = 8
                                }
                                "lecture building" -> {
                                    app.playerLocation = 25
                                }
                                "moonside lake" -> {
                                    app.playerLocation = 16
                                }
                                "old yharnam" -> {
                                    app.playerLocation = 5
                                }
                                "forbidden woods" -> {
                                    app.playerLocation = 13
                                }
                            }
                        }
                        5 -> {
                            when (textEntry.text.lowercase()) {
                                "cathedral ward" -> {
                                    app.playerLocation = 4
                                }
                                "church of the good chalice" -> {
                                    app.playerLocation = 6
                                }
                                "graveyard of the darkbeast" -> {
                                    app.playerLocation = 20
                                }
                            }
                        }
                        6 -> {
                            when (textEntry.text.lowercase()) {
                                "old yharnam" -> {
                                    app.playerLocation = 5
                                }
                            }
                        }
                        7 -> {
                            when (textEntry.text.lowercase()) {
                                "cathedral ward" -> {
                                    app.playerLocation = 4
                                }
                                "abandoned old workshop" -> {
                                    app.playerLocation = 8
                                }
                                "lower cathedral ward" -> {
                                    app.playerLocation = 9
                                }
                                "upper cathedral ward" -> {
                                    app.playerLocation = 22
                                }
                            }
                        }
                        8 -> {
                            when (textEntry.text.lowercase()) {
                                "cathedral ward" -> {
                                    app.playerLocation = 4
                                }
                                "lower cathedral ward" -> {
                                    app.playerLocation = 9
                                }
                                "healing church workshop" -> {
                                    app.playerLocation = 7
                                }
                            }
                        }
                        9 -> {
                            when (textEntry.text.lowercase()) {
                                "cathedral ward" -> {
                                    app.playerLocation = 4
                                }
                                "healing church workshop" -> {
                                    app.playerLocation = 7
                                }
                                "abandoned old workshop" -> {
                                    app.playerLocation = 8
                                }
                            }
                        }
                        10 -> {
                            when (textEntry.text.lowercase()) {
                                "cathedral ward" -> {
                                    app.playerLocation = 4
                                }
                            }
                        }
                        11 -> {
                            when (textEntry.text.lowercase()) {
                                "cathedral ward" -> {
                                    app.playerLocation = 4
                                }
                                "witch's abode" -> {
                                    app.playerLocation = 12
                                }
                                "forsaken cainhurst castle" -> {
                                    app.playerLocation = 33
                                }
                            }
                        }
                        12 -> {
                            when (textEntry.text.lowercase()) {
                                "hemwick charnel lane" -> {
                                    app.playerLocation = 11
                                }
                            }
                        }
                        13 -> {
                            when (textEntry.text.lowercase()) {
                                "cathedral ward" -> {
                                    app.playerLocation = 4
                                }
                                "1st floor sickroom" -> {
                                    app.playerLocation = 0
                                }
                                "forbidden grave" -> {
                                    app.playerLocation = 14
                                }
                            }
                        }
                        14 -> {
                            when (textEntry.text.lowercase()) {
                                "forbidden woods" -> {
                                    app.playerLocation = 13
                                }
                                "byrgenwerth" -> {
                                    app.playerLocation = 15
                                }
                            }
                        }
                        15 -> {
                            when (textEntry.text.lowercase()) {
                                "forbidden grave" -> {
                                    app.playerLocation = 14
                                }
                                "moonside lake" -> {
                                    app.playerLocation = 16
                                }
                            }
                        }
                        16 -> {
                            when (textEntry.text.lowercase()) {
                                "byrgenwerth" -> {
                                    app.playerLocation = 15
                                }
                                "cathedral ward" -> {
                                    app.playerLocation = 4
                                }
                                "yahar'gul unseen village" -> {
                                    app.playerLocation = 18
                                }
                            }
                        }
                        17 -> {
                            when (textEntry.text.lowercase()) {
                                "yahar'gul chapel" -> {
                                    app.playerLocation = 19
                                }
                                "graveyard of the darkbeast" -> {
                                    app.playerLocation = 20
                                }
                                "advent plaza" -> {
                                    app.playerLocation = 21
                                }
                            }
                        }
                        18 -> {
                            when (textEntry.text.lowercase()) {
                                "cathedral ward" -> {
                                    app.playerLocation = 4
                                }
                                "moonside lake" -> {
                                    app.playerLocation = 16
                                }
                                "advent plaza" -> {
                                    app.playerLocation = 21
                                }
                                "nightmare of mensis" -> {
                                    app.playerLocation = 29
                                }
                            }
                        }
                        19 -> {
                            when (textEntry.text.lowercase()) {
                                "graveyard of the darkbeast" -> {
                                    app.playerLocation = 20
                                }
                                "yahar'gul unseen village" -> {
                                    app.playerLocation = 18
                                }
                                "advent plaza" -> {
                                    app.playerLocation = 21
                                }
                                "hypogean gaol" -> {
                                    app.playerLocation =  17
                                }
                            }
                        }
                        20 -> {
                            when (textEntry.text.lowercase()) {
                                "hypogean gaol" -> {
                                    app.playerLocation = 17
                                }
                                "yahar'gul chapel" -> {
                                    app.playerLocation = 19
                                }
                                "old yharnam" -> {
                                    app.playerLocation = 5
                                }
                            }
                        }
                        21 -> {
                            when (textEntry.text.lowercase()) {
                                "yahar'gul unseen village" -> {
                                    app.playerLocation = 18
                                }
                                "lecture building 2nd floor" -> {
                                    app.playerLocation = 28
                                }
                                "hypogean gaol" -> {
                                    app.playerLocation = 17
                                }
                                "yahar'gul chapel" -> {
                                    app.playerLocation = 19
                                }
                            }
                        }
                        22 -> {
                            when (textEntry.text.lowercase()) {
                                "healing church workshop" -> {
                                    app.playerLocation = 7
                                }
                                "lumenflower gardens" -> {
                                    app.playerLocation = 23
                                }
                            }
                        }
                        23 -> {
                            when (textEntry.text.lowercase()) {
                                "upper cathedral ward" -> {
                                    app.playerLocation = 22
                                }
                                "altar of despair" -> {
                                    app.playerLocation = 24
                                }
                            }
                        }
                        24 -> {
                            when (textEntry.text.lowercase()) {
                                "lumenflower gardens" -> {
                                    app.playerLocation = 23
                                }
                            }
                        }
                        25 -> {
                            when (textEntry.text.lowercase()) {
                                "nightmare frontier" -> {
                                    app.playerLocation = 26
                                }
                                "lecture building 2nd floor" -> {
                                    app.playerLocation = 28
                                }
                                "cathedral ward" -> {
                                    app.playerLocation = 4
                                }
                            }
                        }
                        26 -> {
                            when (textEntry.text.lowercase()) {
                                "lecture building" -> {
                                    app.playerLocation = 25
                                }
                                "amygdala's chamber" -> {
                                    app.playerLocation = 27
                                }
                            }
                        }
                        27 -> {
                            when (textEntry.text.lowercase()) {
                                "nightmare frontier" -> {
                                    app.playerLocation = 26
                                }
                            }
                        }
                        28 -> {
                            when (textEntry.text.lowercase()) {
                                "lecture building" -> {
                                    app.playerLocation = 25
                                }
                                "nightmare of mensis" -> {
                                    app.playerLocation =  29
                                }
                                "advent plaza" -> {
                                    app.playerLocation = 21
                                }
                            }
                        }
                        29 -> {
                            when (textEntry.text.lowercase()) {
                                "yahar'gul unseen village" -> {
                                    app.playerLocation = 18
                                }
                                "lecture building 2nd floor" -> {
                                    app.playerLocation = 28
                                }
                                "mergo's loft base" -> {
                                    app.playerLocation = 30
                                }
                                "mergo's loft middle" -> {
                                    app.playerLocation = 31
                                }
                            }
                        }
                        30 -> {
                            when (textEntry.text.lowercase()) {
                                "nightmare of mensis" -> {
                                    app.playerLocation = 29
                                }
                                "mergo's loft middle" -> {
                                    app.playerLocation = 31
                                }
                            }
                        }
                        31 -> {
                            when (textEntry.text.lowercase()) {
                                "nightmare of mensis" -> {
                                    app.playerLocation = 29
                                }
                                "mergo's loft base" -> {
                                    app.playerLocation = 30
                                }
                                "wet nurse's lunarium" -> {
                                    app.playerLocation = 32
                                }
                            }
                        }
                        32 -> {
                            when (textEntry.text.lowercase()) {
                                "mergo's loft middle" -> {
                                    app.playerLocation = 31
                                }
                            }
                        }
                        33 -> {
                            when (textEntry.text.lowercase()) {
                                "hemwick charnel lane" -> {
                                    app.playerLocation = 11
                                }
                                "logarius' seat" -> {
                                    app.playerLocation = 34
                                }
                            }
                        }
                        34 -> {
                            when (textEntry.text.lowercase()) {
                                "forsaken cainhurst castle" -> {
                                    app.playerLocation = 33
                                }
                                "vileblood queen's chamber" -> {
                                    app.playerLocation = 35
                                }
                            }
                        }
                        35 -> {
                            when (textEntry.text.lowercase()) {
                                "logarius' seat" -> {
                                    app.playerLocation = 34
                                }
                            }
                        }
                        36 -> {
                            when (textEntry.text.lowercase()) {
                                "cathedral ward" -> {
                                    app.playerLocation = 4
                                }
                                "nightmare church" -> {
                                    app.playerLocation = 38
                                }
                                "nightmare grand cathedral" -> {
                                    app.playerLocation = 37
                                }
                                "underground corpse pile" -> {
                                    app.playerLocation = 39
                                }
                            }
                        }
                        37 -> {
                            when (textEntry.text.lowercase()) {
                                "hunter's nightmare" -> {
                                    app.playerLocation = 36
                                }
                            }
                        }
                        38 -> {
                            when (textEntry.text.lowercase()) {
                                "hunter's nightmare" -> {
                                    app.playerLocation = 36
                                }
                                "underground corpse pile" -> {
                                    app.playerLocation = 39
                                }
                            }
                        }
                        39 -> {
                            when (textEntry.text.lowercase()) {
                                "hunter's nightmare" -> {
                                    app.playerLocation = 36
                                }
                                "nightmare church" -> {
                                    app.playerLocation = 38
                                }
                                "underground cell" -> {
                                    app.playerLocation = 40
                                }
                            }
                        }
                        40 -> {
                            when (textEntry.text.lowercase()) {
                                "underground corpse pile" -> {
                                    app.playerLocation = 39
                                }
                                "surgery altar" -> {
                                    app.playerLocation = 41
                                }
                            }
                        }
                        41 -> {
                            when (textEntry.text.lowercase()) {
                                "underground cell" -> {
                                    app.playerLocation = 40
                                }
                                "research hall" -> {
                                    app.playerLocation = 42
                                }
                            }
                        }
                        42 -> {
                            when (textEntry.text.lowercase()) {
                                "surgery altar" -> {
                                    app.playerLocation = 41
                                }
                                "lumenwood garden" -> {
                                    app.playerLocation = 43
                                }
                            }
                        }
                        43 -> {
                            when (textEntry.text.lowercase()) {
                                "research hall" -> {
                                    app.playerLocation = 42
                                }
                                "astral clocktower" -> {
                                    app.playerLocation = 44
                                }
                            }
                        }
                        44 -> {
                            when (textEntry.text.lowercase()) {
                                "lumenwood garden" -> {
                                    app.playerLocation = 43
                                }
                                "fishing hamlet" -> {
                                    app.playerLocation = 45
                                }
                            }
                        }
                        45 -> {
                            when (textEntry.text.lowercase()) {
                                "astral clocktower" -> {
                                    app.playerLocation = 44
                                }
                                "lighthouse hut" -> {
                                    app.playerLocation = 46
                                }
                                "coast" -> {
                                    app.playerLocation = 47
                                }
                            }
                        }
                        46 -> {
                            when (textEntry.text.lowercase()) {
                                "coast" -> {
                                    app.playerLocation = 47
                                }
                                "fishing hamlet" -> {
                                    app.playerLocation = 45
                                }
                            }
                        }
                        47 -> {
                            when (textEntry.text.lowercase()) {
                                "fishing hamlet" -> {
                                    app.playerLocation = 45
                                }
                                "lighthouse hut" -> {
                                    app.playerLocation = 46
                                }
                            }
                        }
                        48 -> {
                            when (textEntry.text.lowercase()) {

                            }
                        }
                        49 -> {
                            when (textEntry.text.lowercase()) {

                            }
                        }
                    }
                }
                updateView()
                textEntry.text = ""
            }
            lampButton -> {
                if (app.playerLocation != 48) {
                    app.lamp()
                } else {
                    app.playerLocation = app.lastLocation
                }

            }
        }
    }

}

