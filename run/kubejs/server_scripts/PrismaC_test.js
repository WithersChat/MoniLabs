ServerEvents.recipes(event =>{
    event.recipes.gtceu.prismatic_crucible("test2")
        .inputColor(PrismaticColor.RED)
        .itemInputs("minecraft:red_dye")
        .itemOutputs("minecraft:green_dye")
        .EUt(128)
        .duration(100)
        .outputStates(PrismaticColor.GREEN)

    event.recipes.gtceu.prismatic_crucible("test3")
        .inputColor(PrismaticColor.GREEN)
        .itemInputs("minecraft:green_dye")
        .itemOutputs("minecraft:red_dye")
        .EUt(128)
        .duration(100)
        .outputStates(PrismaticColor.RED)

    event.recipes.gtceu.prismatic_crucible("test4")
        .inputColor(PrismaticColor.GREEN)
        .itemInputs("minecraft:stone")
        .itemOutputs("minecraft:cobblestone")
        .EUt(128)
        .duration(100)
        .outputStates(PrismaticColor.RED)

    event.recipes.gtceu.prismatic_crucible("test5")
        .inputColor(PrismaticColor.BASIC)
        .itemInputs("minecraft:white_dye")
        .itemOutputs("minecraft:black_dye")
        .EUt(128)
        .duration(100)
        .outputStates(PrismaticColor.MAGENTA)

    event.recipes.gtceu.prismatic_crucible("test6")
        .inputColor(PrismaticColor.RED)
        .itemInputs("minecraft:stone")
        .itemOutputs("minecraft:diamond", 4)
        .EUt(128)
        .duration(100)
        .outputStates(PrismaticColor.GREEN)
    
    event.recipes.gtceu.prismatic_crucible("test7")
        .inputColor(PrismaticColor.ANY)
        .itemInputs("minecraft:dirt")
        .itemOutputs("minecraft:diamond", 4)
        .EUt(128)
        .duration(100)
        .outputStates(PrismaticColor.GREEN)
})
