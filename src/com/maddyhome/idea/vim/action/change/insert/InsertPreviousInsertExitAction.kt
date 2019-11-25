/*
 * IdeaVim - Vim emulator for IDEs based on the IntelliJ platform
 * Copyright (C) 2003-2019 The IdeaVim authors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package com.maddyhome.idea.vim.action.change.insert;

import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.Editor;
import com.maddyhome.idea.vim.VimPlugin;
import com.maddyhome.idea.vim.action.ComplicatedKeysAction;
import com.maddyhome.idea.vim.command.Argument;
import com.maddyhome.idea.vim.command.Command;
import com.maddyhome.idea.vim.handler.ChangeEditorActionHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class InsertPreviousInsertExitAction extends ChangeEditorActionHandler.SingleExecution
  implements ComplicatedKeysAction {

  @NotNull
  @Override
  public Set<List<KeyStroke>> getKeyStrokesSet() {
    Set<List<KeyStroke>> keys = new HashSet<>();
    keys
      .add(Collections.singletonList(KeyStroke.getKeyStroke(KeyEvent.VK_2, KeyEvent.CTRL_MASK | KeyEvent.SHIFT_MASK)));
    keys.add(Collections.singletonList(KeyStroke.getKeyStroke(KeyEvent.VK_2, KeyEvent.CTRL_MASK)));
    keys.add(Collections.singletonList(KeyStroke.getKeyStroke(KeyEvent.VK_AT, KeyEvent.CTRL_MASK)));
    return keys;
  }

  @NotNull
  @Override
  public Command.Type getType() {
    return Command.Type.INSERT;
  }

  @Override
  public boolean execute(@NotNull Editor editor,
                         @NotNull DataContext context,
                         int count,
                         int rawCount,
                         @Nullable Argument argument) {
    VimPlugin.getChange().insertPreviousInsert(editor, context, true);
    return false;
  }
}