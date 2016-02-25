/*
 * Copyright (c) 2002-2016 "Neo Technology,"
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
package org.neo4j.kernel.impl.store.format;

import org.neo4j.kernel.impl.store.format.lowlimit.LowLimit;

/**
 * Selects format to use for databases in this JVM, using a system property. By default uses the safest
 * and established format. During development this may be switched in builds to experimental formats
 * to gain more testing there.
 */
public class InternalRecordFormatSelector
{
    public static RecordFormats select()
    {
        //todo: uncomment this loop once high-limits store migration is done.
//        for ( RecordFormats.Factory candidate : Service.load( RecordFormats.Factory.class ) )
//        {
//            return candidate.newInstance();
//        }
        return LowLimit.RECORD_FORMATS;
    }
}
