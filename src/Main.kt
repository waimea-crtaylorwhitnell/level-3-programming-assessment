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
import kotlin.system.exitProcess


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    val app = App()         // Create the app model
    val infoMenu = JPopupMenu()
    val buttonPopup = JPopupMenu()
    val winPopup = JPopupMenu()
    MainWindow(app, infoMenu, buttonPopup, winPopup)         // Create and show the UI, using the app model
}


/**
 * The application class (model)
 * This is the place where any application data should be
 * stored, plus any application logic functions
 */
class App() {
    val locations = mutableListOf<Location>()
    val items = mutableListOf<Item>()
    var playerLocation = 0
    var areaImage: String? = null
    var checkResponse = ""
    var fightResponse = ""


    // location indices, mostly used to keep track
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
    val grandCathedral = 10
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

    // Item indices
    val firstCord = 0
    val secondCord = 1
    val thirdCord = 2
    val fourthCord = 3
    init {
        locations.add(Location("1st Floor Sickroom", "1st-floor-sickroom.png", "Forbidden Woods, and Central Yharnam")) // 0
        locations.add(Location("Central Yharnam", "central-yharnam.png", "1st Floor Sickroom, Great Bridge, Tomb Of Oedon")) // 1
        locations.add(Location("Great Bridge", "great-bridge.png", "Central Yharnam")) // 2
        locations.add(Location("Tomb Of Oedon", "tomb-of-oedon.png", "Central Yharnam, and Cathedral Ward")) // 3
        locations.add(Location("Cathedral Ward", "cathedral-ward.png", "Tomb Of Oedon, Old Yharnam, Healing Church Workshop, Abandoned Old Workshop, Lower Cathedral Ward, Grand Cathedral, Hemwick Charnel Lane, Forbidden Woods, Moonside Lake, Yahar'gul, Unseen Village, Lecture Building, and Hunter's Nightmare")) // 4
        locations.add(Location("Old Yharnam", "old-yharnam.png", "Cathedral Ward, Church Of The Good Chalice, and Graveyard Of The Darkbeast")) // 5
        locations.add(Location("Church Of The Good Chalice", "church-of-the-good-chalice.png", "Old Yharnam")) // 6
        locations.add(Location("Healing Church Workshop", "healing-church-workshop.png", "Cathedral Ward, Abandoned Old Workshop, Lower Cathedral Ward, and Upper Cathedral Ward")) // 7
        locations.add(Location("Abandoned Old Workshop", "abandoned-old-workshop.png", "Cathedral Ward, Healing Church Workshop, and Lower Cathedral Ward")) // 8
        locations.add(Location("Lower Cathedral Ward", "lower-cathedral-ward.png", "Cathedral Ward, Healing Church Workshop, and Abandoned Old Workshop")) // 9
        locations.add(Location("Great Cathedral", "great-cathedral.png", "Cathedral Ward")) // 10
        locations.add(Location("Hemwick Charnel Lane", "hemwick-charnel-lane.png", "Cathedral Ward, Witch's Abode, and Forsaken Cainhurst Castle")) // 11
        locations.add(Location("Witch's Abode", "witchs-abode.png", "Hemwick Charnel Lane")) // 12
        locations.add(Location("Forbidden Woods", "forbidden-woods.png", "1st Floor Sickroom, Cathedral Ward, and Forbidden Grave")) // 13
        locations.add(Location("Forbidden Grave", "forbidden-grave.png", "Forbidden Woods, and Byrgenwerth")) //14
        locations.add(Location("Byrgenwerth", "byrgenwerth.png", "Forbidden Grave, and Moonside Lake")) //15
        locations.add(Location("Moonside Lake", "moonside-lake.png", "Byrgenwerth, Cathedral Ward, and Yahar'gul Unseen Village")) //16
        locations.add(Location("Hypogean Gaol", "hypogean-gaol.png", "Yahar'gul Chapel, Graveyard Of The Darkbeast, and Advent Plaza")) // 17
        locations.add(Location("Yahar'gul, Unseen Village", "yahargul-unseen-village.png", "Cathedral Ward, Moonside Lake, Advent Plaza, Nightmare Of Mensis")) // 18
        locations.add(Location("Yahar'gul Chapel", "yahargul-chapel.png", "Graveyard Of The Darkbeast, Yahar'gul Unseen Village, Advent Plaza, and Hypogean Gaol")) // 19
        locations.add(Location("Graveyard Of The Darkbeast", "graveyard-of-the-darkbeast.png", "Hypogean Gaol, Yahar'gul Chapel, and Old Yharnam")) // 20
        locations.add(Location("Advent Plaza", "advent-plaza.png", "Yahar'gul Unseen Village, Lecture Building 2nd Floor, Hypogean Gaol, and Yahar'gul Chapel")) // 21
        locations.add(Location("Upper Cathedral Ward", "upper-cathedral-ward.png", "Healing Church Workshop, and Lumenflower Gardens")) // 22
        locations.add(Location("Lumenflower Gardens", "lumenflower-garden.png", "Upper Cathedral Ward, and Altar Of Despair")) // 23
        locations.add(Location("Altar Of Despair", "altar-of-despair.png", "Lumenflower Gardens")) // 24
        locations.add(Location("Lecture Building", "lecture-building.png", "Nightmare Frontier, Lecture Building 2nd Floor, and Cathedral Ward")) // 25
        locations.add(Location("Nightmare Frontier", "nightmare-frontier.png", "Lecture Building, and Amygdala's Chamber")) // 26
        locations.add(Location("Amygdala's Chamber", "amygdalas-chamber.png", "Nightmare Frontier")) // 27
        locations.add(Location("Lecture Building 2nd Floor", "lecture-building-2nd-floor.png", "Lecture Building, Nightmare Of Mensis, and Advent Plaza")) // 28
        locations.add(Location("Nightmare Of Mensis", "nightmare-of-mensis.png", "Yahar'gul Unseen Village, Lecture Building 2nd Floor, Mergo's Loft Base, and Mergo's Loft Middle")) // 29
        locations.add(Location("Mergo's Loft Base", "mergos-loft-base.png", "Nightmare Of Mensis, and Mergo's Loft Middle")) // 30
        locations.add(Location("Mergo's Loft Middle", "mergos-loft-middle.png", "Nightmare Of Mensis, Mergo's Loft Base, and Wet Nurse's Lunarium")) // 31
        locations.add(Location("Wet Nurse's Lunarium", "wet-nurses-lunarium.png", "Mergo's Loft Middle")) // 32
        locations.add(Location("Forsaken Castle Cainhurst", "forsaken-cainhurst-castle.png", "Hemwick Charnel Lane, and Logarius' Seat")) // 33
        locations.add(Location("Logarius' Seat", "logarius-seat.png", "Forsaken Cainhurst Castle, and Vileblood Queen's Chamber")) // 34
        locations.add(Location("Vileblood Queen's Chamber", "vileblood-queens-chamber.png", "Logarius' Seat")) // 35
        locations.add(Location("Hunter's Nightmare", "hunters-nighmare.png", "Cathedral Ward, Nightmare Church, Nightmare Grand Cathedral, and Underground Corpse Pile")) // 36
        locations.add(Location("Nightmare Grand Cathedral", "nightmare-grand-cathedral.png", "Hunter's Nightmare")) // 37
        locations.add(Location("Nightmare Church", "nightmare-church.png", "Hunter's Nightmare, and Underground Corpse Pile")) // 38
        locations.add(Location("Underground Corpse Pile", "underground-corpse-pile.png", "Hunter's Nightmare, Nightmare Church, and Underground Cell")) // 39
        locations.add(Location("Underground Cell", "underground-cell.png", "Underground Corpse Pile, and Surgery Altar")) // 40
        locations.add(Location("Surgery Altar", "surgery-altar.png", "Underground Cell, and Research Hall")) // 41
        locations.add(Location("Research Hall", "research-hall.png", "Surgery Altar, and Lumenwood Garden")) // 42
        locations.add(Location("Lumenwood Garden", "lumenwood-garden.png", "Research Hall, and Astral Clocktower")) // 43
        locations.add(Location("AstralClocktower", "astral-clocktower.png", "Lumenwood Garden, and Fishing Hamlet")) // 44
        locations.add(Location("Fishing Hamlet", "fishing-hamlet.png", "Astral Clocktower, Lighthouse Hut, and Coast")) // 45
        locations.add(Location("Lighthouse Hut", "lighthouse-hut.png", "Coast, and Fishing Hamlet")) // 46
        locations.add(Location("Coast", "coast.png", "Fishing Hamlet, and Lighthouse Hut")) // 47
        locations.add(Location("Hunter's Dream", "hunters-dream.png", "")) // 48

        areaImage = locations[playerLocation].description
    }

    init {
        items.add(Item("1st third of an umbilical cord", "The umbilical cord piece guarded by the Witch's of Hemwick."))
        items.add(Item("2nd third of an umbilical cord", "The umbilical cord piece guarded by Rom, the Vacuous Spider."))
        items.add(Item("3rd third of an umbilical cord", "The umbilical cord piece guarded by the Orphan of Kos."))
        items.add(Item("4th third of an umbilical cord", "The umbilical cord piece guarded by Mergo's Wet Nurse."))
    }

    fun itemList(): String {
        var items2nd = "<html>"
        for (item in items) {
            items2nd = "$items2nd${item.name}<br/>${if (item.acquired) "Acquired" else "Not acquired"}<br/><br/>"
        }
        items2nd += "</html>"
        return(items2nd)
    }

    fun lamp() {
        playerLocation = 48
    }
}

class Location(val name: String, val description: String?, val connections: String) {
    override fun toString(): String {
        return "<html>$name<br>The possible way(s) forwards are $connections"
    }
}

class Item(val name: String, val description: String?, var acquired: Boolean = false) {
    override fun toString():String {
        return "<html>$name<br/>$description</html>"
    }
}

/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow(val app: App, val infoMenu: JPopupMenu, val buttonPopup: JPopupMenu, val winPopup: JPopupMenu) : JFrame(), ActionListener {

    // Fields to hold the UI elements
    private lateinit var titleLabel: JLabel
    private lateinit var infoLabel: JLabel
    private lateinit var imageLabel: JLabel
    private lateinit var textEntry: JTextField
    private lateinit var areaButton: JButton
    private lateinit var fightButton: JButton
    private lateinit var checkButton: JButton
    private lateinit var itemButton: JButton
    private lateinit var lampButton: JButton

    // pop-up setup
    private lateinit var itemMenu: ItemMenu
    private lateinit var checkPopUp: ButtonPopup
    private lateinit var fightPopUp: ButtonPopup
    private lateinit var instPopUp: InstPopup
    private lateinit var winPopUp: WinPopup

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

        itemMenu = ItemMenu(app)
        checkPopUp = ButtonPopup(app)
        fightPopUp = ButtonPopup(app)
        instPopUp = InstPopup(app)
        winPopUp = WinPopup(app)

        titleLabel = JLabel("Bloodborne")
        titleLabel.horizontalAlignment = SwingConstants.CENTER
        titleLabel.bounds = Rectangle(500, 44, 200, 48)
        titleLabel.font = titleFont
        add(titleLabel)

        infoLabel = JLabel(" ")
        infoLabel.border = BorderFactory.createLineBorder(Color(127, 127, 127), 5)
        infoLabel.horizontalAlignment = SwingConstants.CENTER
        infoLabel.bounds = Rectangle(130, 130, 470, 230)
        infoLabel.font = infoFont
        add(infoLabel)

        imageLabel = JLabel()
        imageLabel.border = BorderFactory.createLineBorder(Color(127, 127, 127), 5)
        imageLabel.bounds = Rectangle(600, 130, 470, 230)
        add(imageLabel)

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
        var count = 0
        for (item in app.items) {
            if (item.acquired) {
                count++
            }
        }
        lampButton.isEnabled = count == 4
        textEntry.isEnabled = app.playerLocation != 48
        areaButton.isEnabled = app.playerLocation != 48
        // Return other text information
        if (app.playerLocation != 48) {
            infoLabel.text = app.locations[app.playerLocation].toString()
        } else {
            infoLabel.text = app.locations[app.playerLocation].name
        }
        // Get the image file
        app.areaImage = app.locations[app.playerLocation].description
        print(app.areaImage)
        var image = ImageIcon("docs/images/" + app.areaImage).image
        // Scale the image to fit the label
        image = image.getScaledInstance(480, 230, Image.SCALE_SMOOTH)
        // And show it
        imageLabel.icon = ImageIcon(image)
        app.checkResponse = "<html>"
        app.fightResponse = "</html>"
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
                    }
                }
                textEntry.text = ""
            }
            lampButton -> {
                app.lamp()
                winPopUp.isVisible = true
                exitProcess(48)
            }
            itemButton -> {
                itemMenu.updateView()
                itemMenu.isVisible = true
            }
            checkButton -> {
                when (app.playerLocation) {
                    12 -> {
                        if (app.items[0].acquired != true) {
                            app.checkResponse += "The power of an umbilical cord can be felt, protected by a powerful foe.</html>"
                            checkPopUp.updateView()
                            checkPopUp.isVisible = true
                        } else {
                            app.checkResponse += "The power of an umbilical cord once present, is no longer felt"
                            checkPopUp.updateView()
                            checkPopUp.isVisible = true
                        }
                    }
                    16 -> {
                        if (app.items[1].acquired != true) {
                            app.checkResponse += "The power of an umbilical cord can be felt, protected by a powerful foe.</html>"
                            checkPopUp.updateView()
                            checkPopUp.isVisible = true
                        } else {
                            app.checkResponse += "The power of an umbilical cord once present, is no longer felt"
                            checkPopUp.updateView()
                            checkPopUp.isVisible = true
                        }
                    }
                    32 -> {
                        if (app.items[3].acquired != true) {
                            app.checkResponse += "The power of an umbilical cord can be felt, protected by a powerful foe.</html>"
                            checkPopUp.updateView()
                            checkPopUp.isVisible = true
                        } else {
                            app.checkResponse += "The power of an umbilical cord once present, is no longer felt"
                            checkPopUp.updateView()
                            checkPopUp.isVisible = true
                        }
                    }
                    47 -> {
                        if (app.items[2].acquired != true) {
                            app.checkResponse += "The power of an umbilical cord can be felt, protected by a powerful foe.</html>"
                            checkPopUp.updateView()
                            checkPopUp.isVisible = true
                        } else {
                            app.checkResponse += "The power of an umbilical cord once present, is no longer felt"
                            checkPopUp.updateView()
                            checkPopUp.isVisible = true
                        }
                    }
                    else -> {
                        app.checkResponse += "While you can see many horrors, the power of an umbilical cord is absent.</html>"
                        checkPopUp.updateView()
                        checkPopUp.isVisible = true
                    }
                }
            }
            fightButton -> {
                when (app.playerLocation) {
                    12 -> {
                        if (app.items[0].acquired != true) {
                            app.fightResponse = "With a great deal of effort, you manage to defeat the witch's that dwell here.</html>"
                            app.items[0].acquired = true
                            fightPopUp.updateView()
                            fightPopUp.isVisible = true
                        } else {
                            app.fightResponse = "The horror defending the umbilical cord has already lost to you."
                            fightPopUp.updateView()
                            fightPopUp.isVisible = true
                        }
                    }
                    16 -> {
                        if (app.items[1].acquired != true) {
                            if (app.items[0].acquired) {
                                app.fightResponse = "With a great deal of effort, you manage to defeat the Vacuous Spider that roams the lake.</html>"
                                app.items[1].acquired = true
                                fightPopUp.updateView()
                                fightPopUp.isVisible = true
                            } else {
                                app.fightResponse = "You do not yet wield enough insight to overcome Rom the Vacuous."
                                fightPopUp.updateView()
                                fightPopUp.isVisible = true
                            }
                        } else {
                            app.fightResponse = "The horror defending the umbilical cord has already lost to you."
                            fightPopUp.updateView()
                            fightPopUp.isVisible = true
                        }
                    }
                    32 -> {
                        if (app.items[3].acquired != true) {
                            if (app.items[2].acquired) {
                                app.fightResponse = "With a great deal of effort, you manage to defeat Mergo's Wet Nurse who guarded this area.</html>"
                                app.items[3].acquired = true
                                fightPopUp.updateView()
                                fightPopUp.isVisible = true
                            } else {
                                app.fightResponse = "You do not yet wield enough insight to overcome the Wet Nurse of Mergo."
                                fightPopUp.updateView()
                                fightPopUp.isVisible = true
                            }
                        } else {
                            app.fightResponse = "The horror defending the umbilical cord has already lost to you."
                            fightPopUp.updateView()
                            fightPopUp.isVisible = true
                        }
                    }
                    47 -> {
                        if (app.items[2].acquired != true) {
                            if (app.items[1].acquired) {
                                app.fightResponse = "With a great deal of effort, you manage to defeat the Orphan of Kos that laid here.</html>"
                                app.items[2].acquired = true
                                fightPopUp.updateView()
                                fightPopUp.isVisible = true
                            } else {
                                app.fightResponse = "You do not yet wield enough insight to overcome the Orphan of Kos."
                                fightPopUp.updateView()
                                fightPopUp.isVisible = true
                            }
                        } else {
                            app.fightResponse = "The horror defending the umbilical cord has already lost to you."
                            fightPopUp.updateView()
                            fightPopUp.isVisible = true
                        }
                    }
                    else -> {
                        app.fightResponse = "There's nothing here to fight."
                        fightPopUp.updateView()
                        fightPopUp.isVisible = true
                    }
                }
            }
        }
        updateView()
    }
}

class ItemMenu(val app: App): JDialog(), ActionListener {
    private lateinit var itemList: JLabel

    /**
     * Configure the UI
     */
    init {
        configureWindow()
        addControls()
        setLocationRelativeTo(null)     // Centre the window
    }

    /**
     * Setup the dialog window
     */
    private fun configureWindow() {
        title = ""
        contentPane.preferredSize = Dimension(400, 475)
        isResizable = false
        isModal = true
        layout = null
        pack()
    }

    /**
     * Populate the window with controls
     */
    private fun addControls() {
        val baseFont = Font(Font.SANS_SERIF, Font.PLAIN, 24)
        val bigFont = Font(Font.SANS_SERIF, Font.PLAIN, 70)

        val message = JLabel("ITEMS")
        message.bounds = Rectangle(25, 5, 350, 75)
        message.horizontalAlignment = SwingConstants.CENTER
        message.font = bigFont
        add(message)

        itemList = JLabel(app.itemList())
        itemList.bounds = Rectangle(25, 85, 350, 400)
        itemList.horizontalAlignment = SwingConstants.CENTER
        itemList.font = baseFont
        add(itemList)
    }

    fun updateView() {
        itemList.text = app.itemList()
    }

    /**
     * Handle UI actions such as button clicks
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {

        }
    }

}

class ButtonPopup(val app: App): JDialog(), ActionListener {
    private lateinit var buttonResponse: JLabel

    /**
     * Configure the UI
     */
    init {
        configureWindow()
        addControls()
        setLocationRelativeTo(null)     // Centre the window
    }

    /**
     * Setup the dialog window
     */
    private fun configureWindow() {
        title = ""
        contentPane.preferredSize = Dimension(400, 110)
        isResizable = false
        isModal = true
        layout = null
        pack()
    }

    /**
     * Populate the window with controls
     */
    private fun addControls() {
        val baseFont = Font(Font.SANS_SERIF, Font.PLAIN, 24)

        buttonResponse = JLabel(app.checkResponse + app.fightResponse)
        buttonResponse.bounds = Rectangle(25, 5, 375, 90)
        buttonResponse.horizontalAlignment = SwingConstants.CENTER
        buttonResponse.font = baseFont
        add(buttonResponse)
    }

    fun updateView() {
        buttonResponse.text = (app.checkResponse + app.fightResponse)
    }

    /**
     * Handle UI actions such as button clicks
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {

        }
    }
}

class InstPopup(val app: App): JDialog(), ActionListener {
    private lateinit var introText: JLabel

    /**
     * Configure the UI
     */
    init {
        configureWindow()
        addControls()
        setLocationRelativeTo(null)     // Centre the window

        isVisible = true
    }

    /**
     * Setup the dialog window
     */
    private fun configureWindow() {
        title = ""
        contentPane.preferredSize = Dimension(600, 300)
        isResizable = false
        isModal = true
        layout = null
        pack()
    }

    /**
     * Populate the window with controls
     */
    private fun addControls() {
        val baseFont = Font(Font.SANS_SERIF, Font.PLAIN, 24)
        val bigFont = Font(Font.SANS_SERIF, Font.PLAIN, 70)

        // Adding <html> to the label text allows it to wrap
        val message = JLabel("INSTRUCTIONS")
        message.bounds = Rectangle(25, 5, 550, 75)
        message.horizontalAlignment = SwingConstants.CENTER
        message.font = bigFont
        add(message)

        introText = JLabel("<html>Welcome to the world of Bloodborne. Traverse the map in search of umbilical cords, you require four to win. Writing down where you've been may be a good idea, due to the size of the map. Have fun!!</html>")
        introText.bounds = Rectangle(25, 85, 550, 210)
        introText.horizontalAlignment = SwingConstants.CENTER
        introText.font = baseFont
        add(introText)
    }

    /**
     * Handle UI actions such as button clicks
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {

        }
    }
}

class WinPopup(val app: App): JDialog(), ActionListener {
    private lateinit var winText: JLabel

    /**
     * Configure the UI
     */
    init {
        configureWindow()
        addControls()
        setLocationRelativeTo(null)     // Centre the window
    }

    /**
     * Setup the dialog window
     */
    private fun configureWindow() {
        title = ""
        contentPane.preferredSize = Dimension(600, 300)
        isResizable = false
        isModal = true
        layout = null
        pack()
    }

    /**
     * Populate the window with controls
     */
    private fun addControls() {
        val baseFont = Font(Font.SANS_SERIF, Font.PLAIN, 24)
        val bigFont = Font(Font.SANS_SERIF, Font.PLAIN, 70)

        // Adding <html> to the label text allows it to wrap
        val message = JLabel("YOU WON")
        message.bounds = Rectangle(25, 5, 550, 75)
        message.horizontalAlignment = SwingConstants.CENTER
        message.font = bigFont
        add(message)

        winText = JLabel("Congratulations, you survived the night and escaped the hunt!")
        winText.bounds = Rectangle(25, 85, 550, 210)
        winText.horizontalAlignment = SwingConstants.CENTER
        winText.font = baseFont
        add(winText)
    }

    /**
     * Handle UI actions such as button clicks
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {

        }
    }
}