package model

import java.util.*

interface RequestEvent {

    val eventPriority: EventPriority

    sealed class EventPriority(val priorityValue: Int) {
        class WHENEVER : EventPriority(34)
        class MEDIUM : EventPriority(20)
        class URGENT : EventPriority(1)
    }

    class PQSort : Comparator<RequestEvent> {
        override fun compare(requestEvent: RequestEvent, requestEventOther: RequestEvent): Int {
            return requestEvent.eventPriority.priorityValue.compareTo(requestEventOther.eventPriority.priorityValue)
        }
    }
}

interface EverPresent
// Once popped off queue, a fresh copy will be inserted at some point back into the queue.

interface ReplaceOtherInstances
// Only one instance of the implementing class will be held in the queue, the adding of a new instance to the queue will replace any others.

sealed class BaseRequestEvent(override val eventPriority: RequestEvent.EventPriority = RequestEvent.EventPriority.WHENEVER()) : RequestEvent

class BackgroundSyncRequestEvent : BaseRequestEvent(), EverPresent
class LocationRequestEvent : BaseRequestEvent(eventPriority = RequestEvent.EventPriority.URGENT()), ReplaceOtherInstances
class StatusRequestEvent : BaseRequestEvent(eventPriority = RequestEvent.EventPriority.MEDIUM()), ReplaceOtherInstances