/**
 * Graphium Neo4j - Map Matching module of Graphium
 * Copyright © 2017 Salzburg Research Forschungsgesellschaft (graphium@salzburgresearch.at)
 *
 * This program is free software: you can redistribute it and/or modify
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
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package at.srfg.graphium.mapmatching.adapter.impl;

import java.util.Date;

import at.srfg.graphium.io.adapter.IAdapter;
import at.srfg.graphium.mapmatching.dto.TrackMetadataDTO;
import at.srfg.graphium.mapmatching.model.ITrackMetadata;
import at.srfg.graphium.mapmatching.model.impl.TrackMetadataImpl;

/**
 * @author mwimmer
 *
 */
public class MetadataDTO2MetadataAdapter implements IAdapter<ITrackMetadata, TrackMetadataDTO> {

	@Override
	public ITrackMetadata adapt(TrackMetadataDTO metadataToAdapt) {
		if (metadataToAdapt == null) {
			return null;
		}
		
		ITrackMetadata metadata = new TrackMetadataImpl();
		metadata.setDuration(new Date(metadataToAdapt.getDuration()));
		metadata.setEndDate(new Date(metadataToAdapt.getEndDate()));
		metadata.setId(metadataToAdapt.getId());
		metadata.setLength(metadataToAdapt.getLength());
		metadata.setNumberOfPoints(metadataToAdapt.getNumberOfPoints());
		metadata.setStartDate(new Date(metadataToAdapt.getStartDate()));
		return metadata;
	}

}
