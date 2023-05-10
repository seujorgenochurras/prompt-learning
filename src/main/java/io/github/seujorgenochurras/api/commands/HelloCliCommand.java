package io.github.seujorgenochurras.api.commands;

import io.github.seujorgenochurras.command.ICommand;
import io.github.seujorgenochurras.command.arg.CommandArgumentBuilder;
import io.github.seujorgenochurras.command.arg.flag.CommandArgs;
import io.github.seujorgenochurras.command.arg.flag.FlagPatternCollection;
import io.github.seujorgenochurras.command.reflections.ValidFlagArgumentTypes;

public class HelloCliCommand implements ICommand {


   @Override
   public void invoke(CommandArgs args) {
      String message = args.getFlagByName("m").getValueAsString();
      System.out.println("Hello " + message);
   }

   @Override
   public FlagPatternCollection commandArgsPattern() {
      return CommandArgumentBuilder
              .startBuild()

              .newFlag()
              .aliases("-f", "--force")
              .addFlag()

              .newFlag()
              .aliases("-m", "--message")
              .returnType(ValidFlagArgumentTypes.STRING)
              .addFlag()

              .newFlag()
              .aliases("-j", "--joke")
              .addFlag()
              .build();
   }

   @Override
   public String[] getNames() {
      return new String[]{"Cli"};
   }

}
