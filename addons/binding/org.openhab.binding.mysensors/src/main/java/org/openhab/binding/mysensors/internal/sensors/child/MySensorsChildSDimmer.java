/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.mysensors.internal.sensors.child;

import org.openhab.binding.mysensors.internal.exception.NoContentException;
import org.openhab.binding.mysensors.internal.protocol.message.MySensorsMessageSubType;
import org.openhab.binding.mysensors.internal.sensors.MySensorsChild;
import org.openhab.binding.mysensors.internal.sensors.variable.MySensorsVariableVPercentage;
import org.openhab.binding.mysensors.internal.sensors.variable.MySensorsVariableVStatus;
import org.openhab.binding.mysensors.internal.sensors.variable.MySensorsVariableVVar1;
import org.openhab.binding.mysensors.internal.sensors.variable.MySensorsVariableVVar2;
import org.openhab.binding.mysensors.internal.sensors.variable.MySensorsVariableVVar3;
import org.openhab.binding.mysensors.internal.sensors.variable.MySensorsVariableVVar4;
import org.openhab.binding.mysensors.internal.sensors.variable.MySensorsVariableVVar5;
import org.openhab.binding.mysensors.internal.sensors.variable.MySensorsVariableVWatt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MySensors Child definition according to MySensors serial API
 * https://www.mysensors.org/download/serial_api_20
 *
 * @author Andrea Cioni
 * @author Tim Oberföll
 *
 */
public class MySensorsChildSDimmer extends MySensorsChild {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public MySensorsChildSDimmer(int childId) {
        super(childId);
        setPresentationCode(MySensorsMessageSubType.S_DIMMER);
        try {
            addVariable(new MySensorsVariableVStatus());
            addVariable(new MySensorsVariableVPercentage());
            addVariable(new MySensorsVariableVWatt());
            addVariable(new MySensorsVariableVVar1());
            addVariable(new MySensorsVariableVVar2());
            addVariable(new MySensorsVariableVVar3());
            addVariable(new MySensorsVariableVVar4());
            addVariable(new MySensorsVariableVVar5());
        } catch (NoContentException e) {
            logger.debug("No content to add: {}", e);
        }
    }

}
