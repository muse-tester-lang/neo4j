/**
 * Copyright (c) 2002-2013 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.kernel.impl.api;

import org.neo4j.kernel.api.StatementContext;

public class LockingStatementContext extends DelegatingStatementContext
{
    private final LockHolder lockHolder;

    public LockingStatementContext( StatementContext actual, LockHolder lockHolder )
    {
        super( actual );
        this.lockHolder = lockHolder;
    }

    @Override
    public void addLabelToNode( long labelId, long nodeId )
    {
        lockHolder.acquireNodeWriteLock( nodeId );
        super.addLabelToNode( labelId, nodeId );
    }

    @Override
    public void removeLabelFromNode( long labelId, long nodeId )
    {
        lockHolder.acquireNodeWriteLock( nodeId );
        super.removeLabelFromNode( labelId, nodeId );
    }
}
