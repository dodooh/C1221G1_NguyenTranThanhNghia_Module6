import {Customer} from './customer.model';
import {TourType} from './tour-type.model';
import {Bound} from './bound.model';

export interface Tour {
  tourId?: string;
  tourName?: string;
  destination?: string;
  startDate?: string;
  finishDate?: string;
  closedRegisterDate?: string;
  peopleAllowed?: number;
  plans?: string;
  participant_required?: string;
  cost?: number;
  flag?: boolean;
  creator?: Customer;
  tourType?: TourType;
  bound?: Bound;
}
